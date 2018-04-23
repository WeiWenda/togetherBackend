package com.together.vivid.service.impl;

import com.together.vivid.service.BaseTest;
import com.together.vivid.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by weiwenda on 2017/9/28.
 */
public class UserServiceImplTest extends BaseTest {
    @Autowired
    UserService userService;
    @Test
    public void testGetMemberClubs() throws Exception {
        System.out.println(userService.getChiefClubs(1));
    }

    @Test
    public void testGetChiefClubs() throws Exception {
        System.out.println(userService.getMemberClubs(2));
    }

    @Test
    public void testGetPreparingActivity() throws Exception {
        System.out.println( userService.getPreparingActivity(1));
    }

    @Test
    public void testGetGoingActivity() throws Exception {
        System.out.println(userService.getGoingActivity(1));
    }

    @Test
    public void testGetDoneActivity() throws Exception {
        System.out.println(userService.getDoneActivity(1,1,1));
    }

    @Test
    public void testGetDoneActivity1() throws Exception {
        Calendar start = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        start.set(2017,7,30,0,0);
        Calendar end = Calendar.getInstance();
        end.set(2017,8,1,24,0);
        System.out.println(userService.getDoneActivity(1,start.getTime(),end.getTime()));
        System.out.println(format.format(start.getTime()));

    }
}