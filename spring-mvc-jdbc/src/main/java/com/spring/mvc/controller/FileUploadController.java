package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr.PanYang on 2018/5/29.
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam("file1") MultipartFile file, HttpServletRequest request) throws IOException {
        String filePath = request.getServletContext().getRealPath("/");
        file.transferTo(new File(filePath + "upload/" + file.getOriginalFilename()));
        return "redirect:success.html";
    }

    @RequestMapping("/uploadFiles")
    public String uploadFiles(@RequestParam("file1") MultipartFile[] files, HttpServletRequest request) throws IOException {
        String filePath = request.getServletContext().getRealPath("/");
        for (MultipartFile file : files) {
            file.transferTo(new File(filePath + "upload/" + file.getOriginalFilename()));
        }
        return "redirect:success.html";
    }

}
