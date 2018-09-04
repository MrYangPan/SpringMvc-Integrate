package com.spring.mvc.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Mr.PanYang on 2018/6/6.
 * 向客户端输出中文数据，解决乱码问题的方法
 */
public class RequestDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //第一种输出方式解决乱码
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");
        out.write("中国");
        out.println(resp.getHeader("Accept-Language") + "<hr/>");
        Enumeration headers = req.getHeaders("Accept");
        while (headers.hasMoreElements()) {
            out.println(headers.nextElement() + "<br/>");
        }
        out.println("<hr/>");
        Enumeration names = req.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            out.println(name + "=" + req.getHeader(name) + "<br/>");
        }



        //第二种方式输出数据，解决乱码
//        resp.getOutputStream().write("中国".getBytes("utf-8"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
