package com.spring.mybatis.controller;

import com.spring.mybatis.model.Account;
import com.spring.mybatis.service.ITestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Mr.PanYang on 2018/5/29.
 */
@Controller
@RequestMapping("/")
public class TestController {

    private Logger logger = Logger.getLogger(TestController.class);
    @Autowired
    private ITestService testService;

    @RequestMapping("/test")
    public String list(HttpServletRequest request, HttpServletResponse response) {
        List<Account> accountList = this.testService.findAccountsById(3);
        request.getSession().setAttribute("accounts", accountList);
        logger.info(accountList);
        return "redirect:index.jsp";
    }

}
