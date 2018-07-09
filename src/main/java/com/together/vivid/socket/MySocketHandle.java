package com.together.vivid.socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.together.vivid.dto.WebSocketEnum;
import com.together.vivid.entity.Message;
import com.together.vivid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.together.vivid.socket.JsonUtil;

public class MySocketHandle extends TextWebSocketHandler {
  @Autowired
  UserService userService;
  @Autowired
  private JsonUtil ju;
  // 线上人数
  private static int count;
  //在线用户列表
  private static final Map<Integer, WebSocketSession> users;

  static {
    users = new HashMap<>();
  }

  private static final String CLIENT_ID = "userId";

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    MySocketHandle.addOnlineCount();
    System.out.println("成功建立连接，目前连接人数：" + getOnlineCount());
  }

  public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
    subOnlineCount();
    System.out.println("连接已关闭,目前连接人数：" + getOnlineCount());
  }

  public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
    System.out.println("text message: " + session.getId() + "-" + message.getPayload());
    try {
      Map<String, Object> reObj = ju.toObject(String.valueOf(message.getPayload()), new TypeReference<Map<String, Object>>() {
      });
      switch (WebSocketEnum.stateOf(String.valueOf(reObj.get("type")))) {
        case LOGIN:
          users.put((Integer) reObj.get("userId"), session);
          List<Message> historyMessage = userService.getHistoryMessage((Integer) reObj.get("userId"));
          if (historyMessage.size() > 0) {
            session.sendMessage(getContentArray(historyMessage));
          }
          //从数据库中取出未读消息并发送
//          System.out.println(users);
          break;
        case MESSAGEP2P:
          pushMsg((Integer) reObj.get("from"), (Integer) reObj.get("to"), new TextMessage(ju.toStr(reObj.get("data"))));
          break;
        case ERROR:
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private TextMessage getContentArray(List<Message> historyMessages) {
    ArrayList<Object> tmp = new ArrayList<>();
    for (Message message : historyMessages) {
      tmp.addAll(ju.toObject(message.getContent(), new TypeReference<List<Map<String, Object>>>() {
      }));
    }
    return new TextMessage(ju.toStr(tmp));
  }

  public static int getOnlineCount() {
    return count;
  }

  public static void addOnlineCount() {
    count++;
  }

  public static void subOnlineCount() {
    count--;
  }

  public boolean pushMsg(Integer from , Integer to, TextMessage message) throws Exception {
    if (users.get(to) == null || !users.get(to).isOpen()) {
      //将消息存入数据库
      userService.saveMessage(from, to, message.getPayload());
      return false;
    } else {
      users.get(to).sendMessage(message);
      return true;
    }
  }
  public boolean pushMsg( Integer to, TextMessage message) throws IOException {
    if (users.get(to) == null || !users.get(to).isOpen()) {
      //将消息存入数据库
      userService.saveMessage(-1, to, message.getPayload());
      return false;
    } else {
      users.get(to).sendMessage(message);
      return true;
    }
  }

  /**
   * 给全部连接
   *
   * @param message
   * @return
   */
  public boolean pushMsg(TextMessage message) {
    for (WebSocketSession ssion : users.values()) {
      try {
        if (ssion.isOpen()) {
          ssion.sendMessage(message);
        }
      } catch (IOException e) {
        e.printStackTrace();
        return false;
      }
    }
    return true;
  }
}