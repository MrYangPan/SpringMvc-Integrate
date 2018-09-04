package com.spring.mvc.controller;

import com.spring.mvc.entities.Product;
import com.spring.mvc.entities.ProductList;
import com.spring.mvc.entities.ProductMap;
import com.spring.mvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mr.PanYang on 2018/6/1.
 */
@Controller
public class TestController {

    //  region  自动参数映射

    // http://localhost:8080/action?id=1&name=张
    @RequestMapping("/action")
    public String action(Model model, int id, String name) {
        model.addAttribute("message", "name=" + name + ",id=" + id);
        System.out.println("测试");
        return "action";
    }

    //  http://localhost:8080/action0?id=1&name=张&price=99
    @RequestMapping("/action0")
    public String action0(Model model, Product product) {
        model.addAttribute("message", product);
        return "action";
    }

    //  http://localhost:8080/form.html
    @RequestMapping("/action1")
    public String action1(Model model, User user) {
        model.addAttribute("message", user.getUsername() + "," + user.getProduct().getName());
        return "action";
    }

    //  http://localhost:8080/action2?items[0].name=iphone&items[1].name=book
    @RequestMapping("/action2")
    public String action2(Model model, ProductList productList) {
        model.addAttribute("message", productList.getItems().get(0) + "<br/>" + productList.getItems().get(1));
        return "action";
    }

    //  http://localhost:8080/action3?items[p1].name=pen&items[p2].name=box
    @RequestMapping("/action3")
    public String action3(Model model, ProductMap map) {
        model.addAttribute("message", map.getItems().get("p1") + "<br/>" + map.getItems().get("p2"));
        return "action";
    }

    //  http://localhost:8080/action4?id=tom&id=rose
    @RequestMapping("/action4")
    public String action4(Model model, @RequestParam("id") List<String> ids) {
        model.addAttribute("message", Arrays.deepToString(ids.toArray()));
        return "action";
    }

    // endregion

    // region   List与数组直接绑定自定义数据类型与AJAX

    @RequestMapping("/action5")
    public void action5(@RequestBody List<Product> products, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        System.out.println(Arrays.deepToString(products.toArray()));
        response.getWriter().write("添加成功");
    }


    // endregion


}