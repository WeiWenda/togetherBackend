package com.together.vivid.dao;

import com.together.vivid.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by weiwenda on 2017/9/26.
 */
public interface UserDao {
  void saveUser(@Param("name") String name, @Param("password") String password, @Param("email") String email);

  User queryById(int id);

  User queryByPhone(@Param("phone") String phone, @Param("password") String password);

  User queryByEmail(@Param("email") String e_mail, @Param("password") String password);

  List<User> queryByClubID(int club_id);

  void updateById(@Param("user_id") int user_id, @Param("domain") String domain, @Param("value") String new_value);

  User queryByOnlyEmail(@Param("email") String e_mail);

  List<Map<String, Object>> queryByFriendship(@Param("user_id")int user_id);
}
