package com.together.vivid.service.impl;

import com.together.vivid.entity.Club;
import com.together.vivid.service.BaseTest;
import com.together.vivid.service.ClubService;
import com.together.vivid.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by weiwenda on 2017/9/28.
 */
public class ClubServiceImplTest extends BaseTest {
    @Autowired
    ClubService clubService;
    @Test
    public void testSaveClub() throws Exception {
        Club club = new Club();
        club.setChiefId(1);
        club.setName("someclub");
        clubService.saveClub(club);

    }
    @Test
    public void testGetMembers() throws Exception {
        System.out.println(clubService.getMembers(1));
    }

    @Test
    public void testGetRecentActivity() throws Exception {
        System.out.println(clubService.getRecentActivity(1,3));
    }
}