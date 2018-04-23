package com.together.vivid.entity;

import com.together.vivid.dto.ParticipateStateEnum;

/**
 * Created by weiwenda on 2017/9/28.
 */
public class Participate {
    private int userId;
    private int activityId;
    private int state;
    private User user;
    private ParticipateStateEnum stateEnum;

    public void setState(int state) {
        this.state = state;
        this.stateEnum = ParticipateStateEnum.stateOf(state);
    }

    @Override
    public String toString() {
        return "Participate{" +
                "userId=" + userId +
                ", activityId=" + activityId +
                ", state=" + state +
                ", user=" + user +
                ", stateEnum=" + stateEnum +
                '}';
    }

    public Participate() {}

    public Participate(int user_id, int activity_id, int state) {
        this.userId = user_id;
        this.activityId = activity_id;
        this.state = state;
    }

    public int getUserId() {
        return userId;
    }

    public int getActivityId() {
        return activityId;
    }

    public int getState() {
        return state;
    }
}
