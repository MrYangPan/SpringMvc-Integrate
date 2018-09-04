package com.spring.mvc.controller;

import com.spring.mvc.dao.entity.Account;
import com.spring.mvc.dynamicdatasource.DataSourceHolder;
import com.spring.mvc.service.JdbcInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Mr.PanYang on 2018/5/17.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    private Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    JdbcInterface jdbcInterface;

    @RequestMapping(value = "/honeIndex", method = RequestMethod.GET)
    public ModelAndView list() {
        try {
            ModelAndView mav = new ModelAndView();
            DataSourceHolder.setDataSource(DataSourceHolder.dataSourceOne);
            List<Account> list = jdbcInterface.findList();
            DataSourceHolder.setDataSource(DataSourceHolder.dataSourceTwo);
            List<Account> list2 = jdbcInterface.findList();
//            System.out.println(map);
            mav.addObject("list", list);
            mav.addObject("list2", list2);
            mav.setViewName("list");
            return mav;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/searchAccount")
    public ModelAndView searchAccount(@RequestParam(value = "id") int id) throws Exception {
        ModelAndView mav = new ModelAndView();
        DataSourceHolder.setDataSource(DataSourceHolder.dataSourceOne);
        Account account = jdbcInterface.findById(id);
        mav.addObject("account", account);
        mav.setViewName("search");
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Cookie cookie = new Cookie("user", name + "-" + password);
        cookie.setMaxAge(1 * 60);
        Account account = new Account(name, password);
        response.addCookie(cookie);
        HttpSession session = request.getSession();
        session.setAttribute("account", account);
        return "redirect:/main.jsp";
    }

    @RequestMapping("/addMoney")
    public void addMoney() throws Exception {
        DataSourceHolder.setDataSource(DataSourceHolder.dataSourceTwo);
        //测试配置事物是否生效
        jdbcInterface.transfer(10, 1, 2);
        logger.info("addMoney   action  ruining");
    }

}
