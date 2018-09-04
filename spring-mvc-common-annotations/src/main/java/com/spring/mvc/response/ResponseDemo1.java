package com.spring.mvc.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created by Mr.PanYang on 2018/6/6.
 */
public class ResponseDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        test1(resp);
//        test2(resp);
//        test3(resp);
//        test4(resp);
        test5(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void test1(HttpServletResponse response) throws IOException {
        int i = 1;
        OutputStream out = response.getOutputStream();
        out.write((i + "").getBytes());
    }

    private void test2(HttpServletResponse response) throws IOException {
        String str = "中国";
        response.setContentType("text/html;charset=UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(str.getBytes());
        outputStream.write("<br/>".getBytes());
        outputStream.write(str.getBytes("utf-8"));
    }

    private void test3(HttpServletResponse response) throws IOException {
        String data = "中国";
        OutputStream out = response.getOutputStream();
        out.write("<meta http-equiv='Content-Type' content='text/html;charset=UTF-8'>".getBytes());
        out.write(data.getBytes());
        out.write("<hr/>".getBytes());
    }

    private void test4(HttpServletResponse response) throws IOException {
        String data = "中国";
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(data);
        out.write("<hr/>");
    }

    private void test5(HttpServletResponse response) throws IOException {
        response.setDateHeader("Expires", System.currentTimeMillis() + 10 * 24 * 1000 * 60 * 60);
        response.getOutputStream().write("中国".getBytes());
    }
}
