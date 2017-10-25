package com.together.vivid.service.impl;

import com.together.vivid.dao.HabitDao;
import com.together.vivid.dto.GroupedHabit;
import com.together.vivid.entity.Habit;
import com.together.vivid.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.acl.Group;
import java.util.List;

/**
 * Created by weiwenda on 2017/10/17.
 */
@Service
public class PublicServiceImpl implements PublicService{
    @Autowired
    HabitDao habitDao;
    public List<GroupedHabit> getHabits() {
        System.out.println(GroupedHabit.buildFrom(habitDao.getHabits()));
        return GroupedHabit.buildFrom(habitDao.getHabits());
    }

    public List<GroupedHabit> getLabels() {
        return GroupedHabit.buildFrom(habitDao.getLabels());
    }
}
