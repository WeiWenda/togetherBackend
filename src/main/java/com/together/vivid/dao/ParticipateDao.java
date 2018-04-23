package com.together.vivid.dao;

import com.together.vivid.entity.Participate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by weiwenda on 2017/9/28.
 */
public interface ParticipateDao {

    Participate queryByAIUI(@Param("user_id")int user_id, @Param("activity_id")int activity_id);

    void saveParticipate(Participate participate);

    void updateParticipate(@Param("user_id")int user_id,@Param("activity_id") int activity_id,@Param("state") int state);

    List<Participate> queryById(int activity_id);
}
