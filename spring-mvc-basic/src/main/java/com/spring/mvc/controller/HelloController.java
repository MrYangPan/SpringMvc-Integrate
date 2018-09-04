package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mr.PanYang on 2018/6/29.
 */
@Controller
@RequestMapping("/springMvc")
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        System.out.println("走入到 Hello 方法。。。");
        return "success";
    }

    /**
     * @Author: My.PanYang
     * @Description: 占位符绑定到请求参数
     * @Date: 15:27 2018/6/29
     */
    @RequestMapping(value = "/testGetPathVar/{id}", method = RequestMethod.GET)
    public String testGetPathVar(@PathVariable("id") int id) {
        System.out.println(id);
        return "success";
    }

    //region  Put、Delete 请求处理

    /*  HiddenHttpMethodFilter : 过滤器，可以过滤所有的请求，把请求细分为4种
    *
    * */

    @RequestMapping(value = "/testDelete/{id}", method = RequestMethod.DELETE)
    public String testDelete(@PathVariable(value = "id") Integer id) {
        System.out.println("RequestMethod.DELETE:" + id);
        return "success";
    }


    //endregion

}
