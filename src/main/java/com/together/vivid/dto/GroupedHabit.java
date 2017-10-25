package com.together.vivid.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.together.vivid.entity.Habit;

import java.io.Serializable;
import java.util.*;

/**
 * Created by weiwenda on 2017/10/17.
 */
public class GroupedHabit {
    private int key;
    private String name;
    List<DetailHabit> details=new LinkedList<DetailHabit>();
    @Override
    public String toString() {
        return "GroupedHabit{" +
                "id=" + key +
                ", name='" + name + '\'' +
                ", details=" + details +
                '}';
    }

    public GroupedHabit(Habit habit) {
        this.key = habit.getId();
        this.name = habit.getName();
        this.details.add(new DetailHabit(habit.getDetailId(),habit.getDetailName()));
    }

    public static List<GroupedHabit> buildFrom(List<Habit> habits){
        Map<Integer,GroupedHabit> result = new HashMap<Integer, GroupedHabit>();
        for(Habit habit:habits){
            if(result.containsKey(habit.getId())){
                result.get(habit.getId()).details.add(new DetailHabit(habit.getDetailId(),habit.getDetailName()));
            }else{
                result.put(habit.getId(),new GroupedHabit(habit));
            }
        }
        return new ArrayList<GroupedHabit>(result.values());
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DetailHabit> getDetails() {
        return details;
    }

    public void setDetails(List<DetailHabit> details) {
        this.details = details;
    }
}
class DetailHabit {
    public DetailHabit(int id, String name) {
        this.key = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DetailHabit{" +
                "id=" + key +
                ", name='" + name + '\'' +
                '}';
    }

    private int key;
    private String name;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
