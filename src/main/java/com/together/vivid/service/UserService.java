package com.together.vivid.service;

import com.together.vivid.entity.Activity;
import com.together.vivid.entity.Club;
import com.together.vivid.entity.Habit;
import com.together.vivid.entity.User;

import java.util.Date;
import java.util.List;

/**
 * Created by weiwenda on 2017/9/26.
 */
public interface UserService {
    /**
     *@Author:weiwenda
     *@Description:修改特定user_id的用户信息
     *@Date:13:26 2017/10/16
     */
    Boolean updateById(int user_id,String domain,String new_value);
    /**
     *@Author:weiwenda
     *@Description:获取特定user_id的用户信息
     *@Date:14:32 2017/9/28
     */
    User getById(int user_id);
    /**
    * @Author: weiwenda
    * @Description:注册服务
    * @Date: 下午10:35 2018/5/22
    */
    User register(String user,String password,String eMail);
    /**
     *@Author:weiwenda
     *@Description:登录服务
     *@Date:14:33 2017/9/28
     */
    User login(String user, String password);
    /**
     *@Author:weiwenda
     *@Description:获取用户user_id加入的俱乐部，与getChiefClubs互斥
     *@Date:14:25 2017/9/28
     */
    List<Club> getMemberClubs(int user_id);
    /**
     *@Author:weiwenda
     *@Description:获取用户user_id具有管理权限的俱乐部
     *@Date:14:25 2017/9/28
     */
    List<Club> getChiefClubs(int user_id);
    /**
     *@Author:weiwenda
     *@Description:获取筹备中的
     *@Date:15:15 2017/9/28
     */
    List<Activity> getPreparingActivity(int user_id);
    /**
     *@Author:weiwenda
     *@Description:获取进行中的
     * 群组消息的隔离问题
     *@Date:15:16 2017/9/28
     */
    List<Activity> getGoingActivity(int user_id);
    /**
     *@Author:weiwenda
     *@Description:获取历史参加活动,使用翻页模式或起止模式
     * 翻页模式下，page_size表示每次显示的个数，offset 表示请求第几页数据,从0开始
     *@Date:15:18 2017/9/28
     */
    List<Activity> getDoneActivity(int user_id,int page_size,int offset);
    List<Activity> getDoneActivity(int user_id, Date start , Date end);
    /**
     *@Author:weiwenda
     *@Description:获取同城distance'm距离内的活动
     * PS:异地临时组团的活动，需要大量的前期沟通，可信度不高
     *@Date:15:02 2017/9/28
     */
    List<Activity> getEnterableActivity(int distance,int user_id);
    /**
     *@Author:weiwenda
     *@Description:保存新增的标签
     *@Date:17:24 2017/10/18
     */
    Boolean saveHabit(Habit unit);

    boolean resetPassword(String email);
}
