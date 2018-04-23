package com.together.vivid.service.impl;

import com.together.vivid.service.ActivityService;
import com.together.vivid.service.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by weiwenda on 2017/9/28.
 */
public class ActivityServiceImplTest extends BaseTest {
    @Autowired
    ActivityService activitySevice;
    @Test
    public void testAddParticipate() throws Exception {
        System.out.println(activitySevice.addParticipate(1,6));
    }

    @Test
    public void testGetParticipators() throws Exception {
        System.out.println(activitySevice.getParticipators(1));

    }

    @Test
    public void testSignUp() throws Exception {
        System.out.println(activitySevice.signUp(1,6));

    }
}