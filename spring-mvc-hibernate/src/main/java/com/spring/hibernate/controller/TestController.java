package com.spring.hibernate.controller;

import com.spring.hibernate.model.Account;
import com.spring.hibernate.service.ITestHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Mr.PanYang on 2018/5/30.
 */
@Controller
public class TestController {

    @Autowired
    ITestHibernateService testHibernateService;

    @RequestMapping("/test")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        Account account = testHibernateService.getEntity(Account.class, 3);
        HttpSession session = request.getSession();
        session.setAttribute("message", "请求成功！");
        session.setAttribute("account", account);
        return "redirect:index.jsp";
    }


}
