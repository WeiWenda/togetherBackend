package com.together.vivid.service.impl;

import com.together.vivid.dao.*;
import com.together.vivid.entity.*;
import com.together.vivid.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by weiwenda on 2017/9/26.
 */
@Service
public class UserServiceImpl implements UserService {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private MessageDao messageDao;
  @Autowired
  private UserDao userDao;
  @Autowired
  private ClubDao clubDao;
  @Autowired
  private ActivityDao activityDao;
  @Autowired
  private HabitDao habitDao;

  public Boolean updateById(int user_id, String domain, String new_value) {
    userDao.updateById(user_id, domain, new_value);
    return true;
  }

  public User getById(int user_id) {
    return userDao.queryById(user_id);
  }

  @Override
  public User register(String user, String password, String eMail) {
    userDao.saveUser(user, password, eMail);
    return login(eMail, password);
  }

  public User login(String user, String password) {
    String reg1 = "^1[3|4|5|8][0-9]\\d{8}$";
    Pattern pattern1 = Pattern.compile(reg1);
    String reg2 = "^[a-zA-Z0-9_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$";
    Pattern pattern2 = Pattern.compile(reg2);
    if (pattern1.matcher(user).matches()) {
      User tmp = userDao.queryByPhone(user, password);
      if (tmp != null) return tmp;
    } else if (pattern2.matcher(user).matches()) {
      User tmp = userDao.queryByEmail(user, password);
      if (tmp != null) return tmp;
    }
    return null;
  }

  public List<Club> getMemberClubs(int user_id) {
    return clubDao.queryByMemberId(user_id);
  }

  public List<Club> getChiefClubs(int user_id) {
    return clubDao.queryByChiefId(user_id);
  }

  public List<Activity> getPreparingActivity(int user_id) {
    return activityDao.queryPreparing(user_id);
  }

  public List<Activity> getGoingActivity(int user_id) {
    return activityDao.queryGoing(user_id);
  }

  public List<Activity> getDoneActivity(int user_id, int page_size, int offset) {
    return activityDao.queryDoneSeq1(user_id, page_size, offset * page_size);
  }

  public List<Activity> getDoneActivity(int user_id, Date start, Date end) {
    return activityDao.queryDoneSeq2(user_id, start, end);
  }

  public List<Activity> getEnterableActivity(int distance, int user_id) {
    return activityDao.queryEnterable(user_id);
  }

  public Boolean saveHabit(Habit unit) {
    if (habitDao.queryByName(unit.getDetailName()) == 0)
      habitDao.saveHabit(unit);
    return true;
  }

  @Override
  public boolean resetPassword(String email) {
    User user = userDao.queryByOnlyEmail(email);
    if (user != null) {
      userDao.updateById(user.getUserId(), "password", "");
      return true;
    } else
      return false;
  }

  @Override
  public List<Map<String, Object>> getFriends(int user_id) {
    return userDao.queryByFriendship(user_id);
  }

  @Override
  public List<Message> getHistoryMessage(int user_id) {
    return messageDao.get(user_id);
  }

  @Override
  public Boolean saveMessage(int from, int to, String content) {
    messageDao.save(from,to,content);
    return true;
  }

}
