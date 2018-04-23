package com.together.vivid.web;

import com.together.vivid.dto.GroupedHabit;
import com.together.vivid.dto.Result;
import com.together.vivid.entity.Habit;
import com.together.vivid.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.support.HandlerMethodInvocationException;

import java.util.List;

/**
 * Created by weiwenda on 2017/10/17.
 */
@Controller
public class RootController {
    @Autowired
    PublicService publicService;
    @RequestMapping(value = "/habits",method = RequestMethod.GET,produces = {"application/json; charset=utf-8" })
    @ResponseBody private Result<List<GroupedHabit>> getHabits(){
        return new Result<List<GroupedHabit>>(true,publicService.getHabits());
    }
}
