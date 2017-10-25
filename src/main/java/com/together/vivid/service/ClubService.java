package com.together.vivid.service;

import com.together.vivid.entity.Activity;
import com.together.vivid.entity.Club;
import com.together.vivid.entity.User;

import java.util.List;

/**
 * Created by weiwenda on 2017/9/27.
 */
public interface ClubService {
    /**
     *@Author:weiwenda
     *@Description:添加新的Club
     *@Date:14:35 2017/9/28
     */
    void saveClub(Club club);
    /**
     *@Author:weiwenda
     *@Description:删除一个Club，注意级联问题
     *@Date:14:36 2017/9/28
     */
    void removeClub(int club_id);

    /**
     *@Author:weiwenda
     *@Description:获取所有会员的级别、用户名、头像信息
     *@Date:14:00 2017/9/28
     */
    List<User> getMembers(int club_id);
    /**
     *@Author:weiwenda
     *@Description:获取距今日time天的活动列表，用于显示
     *@Date:14:08 2017/9/28
     */
    List<Activity> getRecentActivity(int club_id,int time);
}
