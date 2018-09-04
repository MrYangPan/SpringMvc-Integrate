package com.spring.mvc.controller;

import com.spring.mvc.annotation.Autowired;
import com.spring.mvc.annotation.Controller;
import com.spring.mvc.annotation.RequestMapping;
import com.spring.mvc.service.TestService;

/**
 * Created by Mr.PanYang on 2018/5/24.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired(value = "testService")
    TestService testService;

    @RequestMapping(value = "/index")
    public String index() {
        return "Test Spring Mvc Annotation" + testService.test();
    }


}
