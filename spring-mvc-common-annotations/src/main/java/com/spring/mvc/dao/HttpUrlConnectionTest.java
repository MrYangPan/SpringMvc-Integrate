package com.spring.mvc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Mr.PanYang on 2018/6/4.
 */
public class HttpUrlConnectionTest {

    public static void main(String[] args) throws Exception {
//        urlAction();
        urlAction2();
    }

    public static void urlAction() throws IOException {
        URL url = new URL("https://www.baidu.com/");
        URLConnection uconn = url.openConnection();
        HttpURLConnection conn = (HttpURLConnection) uconn;
        int code = conn.getResponseCode();
        String desc = conn.getResponseMessage();
        String headvalue = conn.getHeaderField("Server");
        InputStream inputStream = conn.getInputStream();
        System.out.println(code + "\t" + desc);
        System.out.println(headvalue);
        System.out.println();
        byte buf[] = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }
        inputStream.close();
        conn.disconnect();
    }

    public static void urlAction2() throws IOException {
        URL url = new URL("https://www.baidu.com/");
        URLConnection uconn = url.openConnection();
        HttpURLConnection conn = (HttpURLConnection) uconn;
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("mheader", "pp");
        OutputStream out = conn.getOutputStream();
        out.write("username=wzhting".getBytes());
        System.out.println(conn.getResponseCode());
        conn.disconnect();
    }


}
