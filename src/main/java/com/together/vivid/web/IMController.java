package com.together.vivid.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/im")
public class IMController {

@RequestMapping("/page")
public String page(HttpServletRequest request, HttpServletResponse response) {
    return "IMpage";
    }
    }