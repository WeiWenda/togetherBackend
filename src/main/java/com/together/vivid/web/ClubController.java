package com.together.vivid.web;

import com.together.vivid.entity.Club;
import com.together.vivid.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by weiwenda on 2017/9/28.
 */
@Controller
@RequestMapping(value = "/club")
public class ClubController {
    @Autowired
    ClubService clubService;
    @RequestMapping(value = "/del",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody
    private String removeClub(int club_id){
        clubService.removeClub(club_id);
        return "true";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody
    private Club saveClub(@RequestBody Club club){
        clubService.saveClub(club);
        return club;
    }
    @RequestMapping(value ="/update",method = RequestMethod.POST,produces = {"application/json; charset=utf-8"})
    @ResponseBody
    private String updateClub(@RequestBody Club club){
        clubService.updateClub(club);
        return "true";
    }
    @RequestMapping(value ="/delete",method = RequestMethod.POST,produces = {"application/json; charset=utf-8"})
    @ResponseBody
    private String removeClub(@RequestBody Club club){
        clubService.removeClub(club.getClubId());
        return "true";
    }
}
