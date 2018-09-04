package com.spring.mvc.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Mr.PanYang on 2018/6/7.
 * 随机生成图片二维码
 */
public class ResponseDemo3 extends HttpServlet {

    private static int WIDTH = 120;
    private static int HEIGHT = 25;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.GRAY);
        g.fillRect(1, 1, WIDTH - 2, HEIGHT - 2);
        g.setColor(Color.YELLOW);
        Random r = new Random();
        for (int i = 0; i < 9; i++) {
            g.drawLine(r.nextInt(WIDTH), r.nextInt(HEIGHT), r.nextInt(WIDTH), r.nextInt(HEIGHT));
        }
        g.setColor(Color.RED);
        g.setFont(new Font("imgFont", Font.BOLD, 20));
        int x = 5;
        for (int i = 0; i < 4; i++) {
            g.drawString(r.nextInt(9) + "", x, 20);
            x += 30;
        }
        ImageIO.write(image, "jpeg", response.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
