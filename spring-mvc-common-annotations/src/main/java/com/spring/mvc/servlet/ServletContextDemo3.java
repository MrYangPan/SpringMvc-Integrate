package com.spring.mvc.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mr.PanYang on 2018/6/5.
 */
public class ServletContextDemo3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        resp.getOutputStream().write("Demo before".getBytes());
        resp.getOutputStream().flush();
        System.out.println(req);
        System.out.println(resp);

        RequestDispatcher rd = sc.getRequestDispatcher("/servlet/ServletContextDemo2");
        rd.forward(req, resp);
        resp.getOutputStream().write("Demo after".getBytes());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
