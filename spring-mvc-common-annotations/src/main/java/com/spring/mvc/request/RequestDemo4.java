package com.spring.mvc.request;

import com.spring.mvc.entities.Student;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Mr.PanYang on 2018/6/6.
 */
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("Demo4<br/>");
        Student s = (Student) req.getAttribute("s");
        out.println(s.getPassword() + "<br/>");
        for (String item : s.getUsername()) {
            out.println(item + "<br/>");
        }
        System.out.println(req.getContextPath());
        out.println("<a href='" + req.getContextPath() + "'/>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
