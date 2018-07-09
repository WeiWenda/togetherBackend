package com.together.vivid.dao;

import com.together.vivid.entity.Message;
import com.together.vivid.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageDao {
  void save(@Param("from")int from, @Param("to")int to , @Param("content") String content);

  List<Message> get(@Param("to") int to);
}
