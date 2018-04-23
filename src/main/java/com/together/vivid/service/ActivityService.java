package com.together.vivid.service;

import com.together.vivid.entity.Activity;
import com.together.vivid.dto.ParticipateStateEnum;
import com.together.vivid.entity.Participate;
import com.together.vivid.entity.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by weiwenda on 2017/9/28.
 */
public interface ActivityService {

    /**
     *@Author:weiwenda
     *@Description:添加签到
     *@Date:15:25 2017/9/28
     */
    ParticipateStateEnum addParticipate(int user_id,int activity_id);
    /**
     *@Author:weiwenda
     *@Description:检查到场人员情况
     *@Date:15:43 2017/9/28
     */
    List<Participate> getParticipators(int activity_id);
    /**
     *@Author:weiwenda
     *@Description:报名活动
     *@Date:22:40 2017/9/28
     */
    ParticipateStateEnum signUp(int user_id,int activity_id);

    /**
     *@Author:weiwenda
     *@Description:添加活动
     *@Date:15:50 2017/10/24
     */
    void saveActivity(Activity activity);
    /**
     *@Author:weiwenda
     *@Description:移除活动
     *@Date:15:50 2017/10/24
     */
    void removeActivity(int activity_id);
    /**
    * @Author: weiwenda
    * @Description: 根据活动id获取活动的详细信息
    * @Date: 下午10:16 2017/10/26
    */
    Activity getById(int id);
}
