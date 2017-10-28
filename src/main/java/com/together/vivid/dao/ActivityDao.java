package com.together.vivid.dao;

import com.together.vivid.entity.Activity;
import com.together.vivid.entity.Participate;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by weiwenda on 2017/9/26.
 */
public interface ActivityDao {
    List<Activity> queryByClubId(@Param("club_id")int club_id,@Param("time") int time);

    List<Activity> queryEnterable(int user_id);

    List<Activity> queryPreparing(int user_id);

    List<Activity> queryGoing(int user_id);

    List<Activity> queryDoneSeq1(@Param("user_id") int user_id, @Param("page_size") int page_size, @Param("offset") int offset);

    List<Activity> queryDoneSeq2(@Param("user_id") int user_id, @Param("start")Date start, @Param("end")Date end);

    void saveActivity(Activity activity);

    void removeActivity(int activity_id);

    int getPartCount(int id);

    Activity getById(int id);

    String getClubName(int id);

}
