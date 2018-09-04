package com.spring.mvc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mr.PanYang on 2018/6/4.
 */
//@WebServlet(urlPatterns = "/", initParams = {@WebInitParam(name = "servlet", value = "spring-servlet.xml")})
public class ServletConfigDemo1 extends HttpServlet {

    private ServletConfig config;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = config.getInitParameter("encoding");
        System.out.println("encoding:   " + value);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
}
