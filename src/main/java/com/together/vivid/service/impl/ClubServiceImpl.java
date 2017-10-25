package com.together.vivid.service.impl;

import com.together.vivid.dao.ActivityDao;
import com.together.vivid.dao.ClubDao;
import com.together.vivid.dao.UserDao;
import com.together.vivid.entity.Activity;
import com.together.vivid.entity.Club;
import com.together.vivid.entity.User;
import com.together.vivid.service.ClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weiwenda on 2017/9/28.
 */
@Service
public class ClubServiceImpl implements ClubService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ClubDao clubDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ActivityDao activityDao;

    public void saveClub(Club club) {
        clubDao.saveClub(club);
    }

    public void removeClub(int club_id) {
        clubDao.removeClub(club_id);
    }

    public List<User> getMembers(int club_id) {
        return userDao.queryByClubID(club_id);
    }

    public List<Activity> getRecentActivity(int club_id, int time) {
        return activityDao.queryByClubId(club_id,time);
    }
}
