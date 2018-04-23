package com.together.vivid.dto;

/**
 * Created by weiwenda on 2017/9/28.
 */
public enum  ParticipateStateEnum {

    SUCCESS(1,"签到成功"),REPEATED(2,"重复签到"),NOTICE(3,"签到成功，但未报名"),ABSENT(4,"报名但未出席"),ABNORMAL(0,"未定义的状态"),REPEATEDSIGN(5,"重复报名"),SUCCESSSIGN(6,"报名成功");

    @Override
    public String toString() {
        return "ParticipateStateEnum{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }

    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    private ParticipateStateEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }
    public static ParticipateStateEnum stateOf(int index) {
        for (ParticipateStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return ABNORMAL;
    }

}
