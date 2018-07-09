package com.together.vivid.dto;

public enum  WebSocketEnum {
  LOGIN("user:online"),MESSAGEP2P("message:one->one"),ERROR("error");
  private String stateInfo;
  private WebSocketEnum(String stateInfo){
    this.stateInfo = stateInfo;
  }
  public static WebSocketEnum stateOf(String index) {
    for (WebSocketEnum state : values()) {
      if (state.getStateInfo().equals(index)) {
        return state;
      }
    }
    return ERROR;
  }

  public String getStateInfo() {
    return stateInfo;
  }
}
