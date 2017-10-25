package com.together.vivid.web;

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
    @RequestMapping(value = "/del",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody
    private String removeActivity(int activity_id){
        activitySevice.removeActivity(activity_id);
        return "true";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody
    private Activity saveActivity(@RequestBody Activity activity){
        activitySevice.saveActivity(activity);
        return activity;
    }
}
