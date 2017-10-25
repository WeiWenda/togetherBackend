package com.together.vivid.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by weiwenda on 2017/9/26.
 */
public class Activity {
    final static String[] STATES = {"报名中", "报名已截止,筹备中", "进行中", "已结束"};
    private int clubId;
    private int activityId;
    private int organizerId;

    private String address;
    private String name;
    private String introduction;
    private Timestamp startTime;
    private Timestamp closeTime;
    private Timestamp endTime;
    private int state;

    private String favicon;
    private int privilege;
    private String notes;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        if(startTime.equals("未设置"))
            this.startTime =new Timestamp(new Date().getTime());
        else
            this.startTime = Timestamp.valueOf(startTime);
    }

    public void setCloseTime(String closeTime) {
        if(closeTime.equals("未设置"))
            this.closeTime =new Timestamp(new Date().getTime());
        else
            this.closeTime = Timestamp.valueOf(closeTime);
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        if(endTime.equals("未设置"))
            this.endTime =new Timestamp(new Date().getTime());
        else
            this.endTime = Timestamp.valueOf(endTime);

    }

    public int getState() {
        return state;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "clubId=" + clubId +
                ", name='" + name + '\'' +
                ", activityId=" + activityId +
                ", startTime=" + startTime +
                '}';
    }

    public int getClubId() {
        return clubId;
    }

    public int getActivityId() {
        return activityId;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}