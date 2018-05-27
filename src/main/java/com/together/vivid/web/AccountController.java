package com.together.vivid.web;

import com.qiniu.util.Auth;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by weiwenda on 2017/9/26.
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody private Result<User> login(@RequestBody User user){
        User tmp = userService.login(user.getName(),user.getPassword());
        if(tmp==null) return new Result<User>(false,"登录失败");
        else return new Result<User>(true,tmp);
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET, produces = {"application/json; charset=utf-8" })
    @ResponseBody private Result<String> logout(){
      return new Result<String>("退出登录",true);
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody private Result<User> register(@RequestBody User user){
        User tmp = userService.register(user.getName(),user.getPassword(),user.geteMail());
        if(tmp==null) return new Result<User>(false,"登录失败");
        else return new Result<User>(true,tmp);
    }
    @RequestMapping(value="resetPasswordRequest",method = RequestMethod.GET,produces = {"application/json; charset=utf-8" })
    @ResponseBody private Result<String> reset(@RequestParam("email") String email){
      if(userService.resetPassword(email))
        return new Result<String>("重置密码成功",true);
        else
          return new Result<String>("重置密码失败",false);
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}

