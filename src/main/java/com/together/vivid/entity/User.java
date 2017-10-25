package com.together.vivid.entity;

import java.util.Date;

/**
 * Created by weiwenda on 2017/9/26.
 */
public class User {
    private int userId;
    private String name;
    private String password;
    private String favicon;
    private String sex;
    private int age;
    private String eMail;
    private String phone;
    private String address;
    private Date registerTime;
    private boolean isSeo;
    private boolean isChief;
    private int level;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", eMail='" + eMail + '\'' +
                ", phone='" + phone + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    public int getUser_id() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date register_time) {
        this.registerTime = register_time;
    }

    public boolean isSeo() {
        return isSeo;
    }

    public void setIsSeo(int isSeo) {
        if(isSeo==0)
            this.isSeo = false;
        else this.isSeo = true;
    }

    public boolean isChief() {
        return isChief;
    }

    public void setIsChief(int isChief) {
        if(isChief==0)
            this.isChief = false;
        else this.isChief = true;
    }
    public int getUserId() {
        return userId;
    }

    public String geteMail() {
        return eMail;
    }
}
