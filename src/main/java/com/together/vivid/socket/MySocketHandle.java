package com.together.vivid.socket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MySocketHandle extends TextWebSocketHandler {

  // 线上人数
  private static int count;
  private static CopyOnWriteArraySet<WebSocketSession> set = new CopyOnWriteArraySet<>();
  private WebSocketSession session;

  @Override
  public void afterConnectionEstablished(WebSocketSession session) {
    this.session = session;
    try {
      set.add(this.session);
    } catch (Exception e) {
      e.printStackTrace();
    }
    MySocketHandle.addOnlineCount();
    System.out.println("目前连接人数：" + getOnlineCount());
  }

  public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
    this.session = session;
    set.remove(this.session);
    subOnlineCount();
    System.out.println("目前连接人数：" + getOnlineCount());
  }

  public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
    System.out.println("text message: " + session.getId() + "-" + message.getPayload());
    for (WebSocketSession ssion : set) {
      try {
        ssion.sendMessage(message);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
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
}