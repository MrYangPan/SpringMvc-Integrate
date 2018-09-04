package com.spring.mvc.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * Created by Mr.PanYang on 2018/6/6.
 */
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String realpath = getServletContext().getRealPath("/files/image-20180606.png");
        String name = realpath.substring(realpath.lastIndexOf("\\") + 1);
        System.out.println(name);
        InputStream in = new FileInputStream(realpath);
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(name, "GBK"));
        ServletOutputStream out = resp.getOutputStream();
        byte buf[] = new byte[1024];
        int len = -1;
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        in.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
