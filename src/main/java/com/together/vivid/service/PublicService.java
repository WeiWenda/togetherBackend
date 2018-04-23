package com.together.vivid.service;

import com.together.vivid.dto.GroupedHabit;
import com.together.vivid.entity.Habit;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weiwenda on 2017/10/17.
 */
public interface PublicService {
    /**
     * @Author:weiwenda
     * @Description:获取habits作为俱乐部标签或用户爱好
     * @Date:15:53 2017/10/17
     */
    List<GroupedHabit> getHabits();
    /**
     *@Author:weiwenda
     *@Description:获取热门标签作为用户标签
     *@Date:16:04 2017/10/18
     */
    List<GroupedHabit> getLabels();
}
