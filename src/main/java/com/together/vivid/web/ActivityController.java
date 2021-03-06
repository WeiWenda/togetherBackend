package com.together.vivid.web;

import com.together.vivid.dto.Result;
import com.together.vivid.entity.Activity;
import com.together.vivid.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by weiwenda on 2017/10/24.
 */
@Controller
@RequestMapping(value = "/activity")
public class ActivityController {
    @Autowired
    ActivityService activitySevice;
    @RequestMapping(value = "/detail",method = RequestMethod.GET,produces = {"application/json; charset=utf-8"})
    @ResponseBody
    private Result<Activity> getById(@RequestParam("id") int id){
        return new Result<Activity>(true,activitySevice.getById(id));
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody
    private String removeActivity(@RequestBody Activity activity){
        activitySevice.removeActivity(activity.getActivityId());
        return "true";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody
    private Activity saveActivity(@RequestBody Activity activity){
        activitySevice.saveActivity(activity);
        return activity;
    }
}
