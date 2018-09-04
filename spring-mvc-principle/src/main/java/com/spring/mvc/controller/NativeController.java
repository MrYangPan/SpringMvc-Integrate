package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mr.PanYang on 2018/5/25.
 */
@Controller
public class NativeController {

    @RequestMapping("/spring")
    public String index(Model model) {
        model.addAttribute("message", "Native  Spring Mvc");
        return "helloWorld";
    }

    @RequestMapping("/html")
    public ModelAndView html() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

}
