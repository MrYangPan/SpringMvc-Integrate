package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Mr.PanYang on 2018/5/31.
 */
@Controller
public class TestController {

    /**
     * @Author: My.PanYang
     * @Description: 防止 CSRF( 跨站请求伪造 ) 攻击
     * @Date: 16:34 2018/5/31
     */
    @RequestMapping(value = "/region_del", method = RequestMethod.GET)
    public String regionDel(HttpServletRequest request, @RequestParam String CSRFToken) {
        HttpSession session = request.getSession();
        if (CSRFToken == null || !CSRFToken.equals(session.getAttribute(com.spring.mvc.utils.CSRFTokenManager.CSRF_TOKEN_FOR_SESSION_ATTR_NAME).toString())) {
            return "redirect:/index.jsp";
        }
        return "redirect:region.html";
    }

    //  校验 AJAX 请求是否支持CSRF防御
    protected boolean isValidCsrfHeaderToken(HttpServletRequest request, HttpSession session) {
        if (request.getHeader("__RequestVerificationToken") == null
                || session.getAttribute(com.spring.mvc.utils.CSRFTokenManager.CSRF_TOKEN_FOR_SESSION_ATTR_NAME) == null
                || !request.getHeader("__RequestVerificationToken")
                .equals(session.getAttribute(com.spring.mvc.utils.CSRFTokenManager.CSRF_TOKEN_FOR_SESSION_ATTR_NAME).toString())) {
            return false;
        }
        return true;
    }

}
