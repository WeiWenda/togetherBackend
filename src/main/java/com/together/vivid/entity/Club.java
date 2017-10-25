package com.together.vivid.entity;

/**
 * Created by weiwenda on 2017/9/26.
 */
public class Club {
    private int clubId;
    private int chiefId;
    private String favicon;
    private String address;
    private String slogan;
    private String introduction;
    private String callnumber;
    private String name;
    private int size;
    private int upperSize;
    private String chiefName;
    private int level;

    public String getChiefName() {
        return chiefName;
    }

    public void setChiefName(String chiefName) {
        this.chiefName = chiefName;
    }

    public int getLevel() {
        return level;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public void setChiefId(int chiefId) {
        this.chiefId = chiefId;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public void setUpperSize(int upperSize) {
        this.upperSize = upperSize;
    }

    public String getFavicon() {
        return favicon;
    }
    public int getClubId() {
        return clubId;
    }

    public int getChiefId() {
        return chiefId;
    }

    public int getUpperSize() {
        return upperSize;
    }

    public String getCallnumber() {
        return callnumber;
    }

    public void setCallnumber(String callnumber) {
        this.callnumber = callnumber;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Club{" +
                "name='" + name + '\'' +
                ", chiefId=" + chiefId +
                ", clubId=" + clubId +
                ", level=" + level +
                '}';
    }
}
