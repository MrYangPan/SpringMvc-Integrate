package com.spring.mvc.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Mr.PanYang on 2018/6/6.
 */
public class RequestDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();
        String qString = request.getQueryString();
        String remoteAddr = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        String remotePort = request.getRemotePort() + "";
        String localAddr = request.getLocalAddr();
        String localName = request.getLocalName();
        String method = request.getMethod();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("getRequestURL():" + url + "<br/>");
        out.println("getRequestURI():" + uri + "<br/>");
        out.println("getQueryString():" + qString + "<br/>");
        out.println("getRemoteAddr():" + remoteAddr + "<br/>");
        out.println("getRemoteHost():" + remoteHost + "<br/>");
        out.println("getRemotePort():" + remotePort + "<br/>");
        out.println("getLocalAddr():" + localAddr + "<br/>");
        out.println("getLocalName():" + localName + "<br/>");
        out.println("getMethod():" + method);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
