package com.together.vivid.dao;

import com.together.vivid.entity.Club;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by weiwenda on 2017/9/26.
 */
public interface ClubDao {

    void saveClub(Club club);

    void removeClub(int club_id);

    void updateClub(Club club);

    List<Club> queryByChiefId(int user_id);

    List<Club> queryByMemberId(int user_id);

}
