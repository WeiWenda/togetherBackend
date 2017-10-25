package com.together.vivid.web;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.together.vivid.dto.GroupedHabit;
import com.together.vivid.dto.Result;
import com.together.vivid.entity.Activity;
import com.together.vivid.entity.Club;
import com.together.vivid.entity.Habit;
import com.together.vivid.entity.User;
import com.together.vivid.service.ActivityService;
import com.together.vivid.service.PublicService;
import com.together.vivid.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.comparator.BooleanComparator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by weiwenda on 2017/9/26.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @Autowired
    private PublicService publicService;
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    @ResponseBody private String upload(@RequestParam("user_id") int user_id){
        String accessKey = "a6Qq5SEfmJxBBNDwpDh5sMX4c03Al3Hn-rHX3CyS";
        String secretKey = "AIq6iIr-vUKaSoo8bFSzupN3rIt09uc4vPkxPdqQ";
        String bucket = "together";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }
    @RequestMapping(value = "/labels",method = RequestMethod.GET,produces = {"application/json; charset=utf-8" })
    @ResponseBody private Result<List<GroupedHabit>> getHabits(){
        return new Result<List<GroupedHabit>>(true,publicService.getLabels());
    }
    @RequestMapping(value = "/addLabel",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody private Result<Boolean> addLabel(@RequestBody Habit unit){
        Boolean tmp = userService.saveHabit(unit);
        if(!tmp) return new Result<Boolean>(false,"更新失败");
        else return new Result<Boolean>(true,true);
    }
    @RequestMapping(value = "/getClubList",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody private Result<List<Club>> getClubs(@RequestParam("type") String type,@RequestParam("user_id") int user_id){
        if(type.equals("member")){
            return new Result<>(true,userService.getMemberClubs(user_id));
        }else if(type.equals("chief")){
            return new Result<>(true,userService.getChiefClubs(user_id));
        }
        return null;
    }
    @RequestMapping(value = "/getActivityList",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody private Result<List<Activity>> getActivities(@RequestParam("type") String type, @RequestParam("user_id") int user_id){
        switch (type){
            case "going":
                return new Result<>(true,userService.getGoingActivity(user_id));
            case "done":
                return new Result<>(true,userService.getDoneActivity(user_id,4,1));
            case "preparing":
                return new Result<>(true,userService.getPreparingActivity(user_id));
        }
        return null;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody private Result<Boolean> update(@RequestBody UpdateUnit unit){
        System.out.printf(unit.user_id+""+unit.domain+""+unit.value);
        Boolean tmp = userService.updateById(unit.user_id,unit.domain,unit.value);
        if(!tmp) return new Result<Boolean>(false,"更新失败");
        else return new Result<Boolean>(true,true);
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody private Result<User> login(@RequestParam("user") String user, @RequestParam("password")String password){
        User tmp = userService.login(user,password);
        if(tmp==null) return new Result<User>(false,"登录失败");
        else return new Result<User>(true,tmp);
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
class UpdateUnit {
    public void setUser_id(String user_id) {
        this.user_id = Integer.parseInt(user_id);
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setValue(String value) {
        this.value = value;
    }

    int user_id;
    String domain;
    String value;

}
