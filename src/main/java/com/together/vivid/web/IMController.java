package com.together.vivid.web;

import com.together.vivid.socket.MySocketHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/im")
public class IMController {
  @Bean
  public MySocketHandle mySocketHandle() {
    return new MySocketHandle();
  }

  @RequestMapping("/page")
  public String page(HttpServletRequest request, HttpServletResponse response) {
    return "IMpage";
  }

  @ResponseBody
  @RequestMapping("/push")
  public Boolean push(@RequestParam(required = false) int sessionId,
                     HttpServletResponse response){
    Boolean msg;
    if (StringUtils.isEmpty(sessionId)) {
      msg =mySocketHandle().pushMsg(new TextMessage("服务器推送信息了"));
      System.out.println(msg);
    }else{
      try {
        msg =mySocketHandle().pushMsg(sessionId, new TextMessage("服务器推送信息了"));
      } catch (IOException e) {
        msg = false;
        e.printStackTrace();
      }
    }
    return msg;
  }

}