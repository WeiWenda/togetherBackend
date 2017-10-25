package com.together.vivid.dao;

import com.together.vivid.entity.Habit;

import java.util.List;

/**
 * Created by weiwenda on 2017/10/17.
 */
public interface HabitDao {
    List<Habit> getHabits();

    List<Habit> getLabels();

    void saveHabit(Habit unit);

    int queryByName(String detailName);
}
