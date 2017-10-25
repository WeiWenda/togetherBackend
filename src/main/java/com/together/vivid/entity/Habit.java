package com.together.vivid.entity;

import java.util.List;

/**
 * Created by weiwenda on 2017/10/17.
 */
public class Habit {
    private int id;
    private String name;
    private int detailId;
    private String detailName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Habit{" +
                "detail_name='" + detailName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

