package com.spring.mvc.servlet;

import com.spring.mvc.annotation.Autowired;
import com.spring.mvc.annotation.Controller;
import com.spring.mvc.annotation.RequestMapping;
import com.spring.mvc.annotation.Service;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr.PanYang on 2018/5/24.
 */

public class DispatcherServlet extends HttpServlet {

    List<String> classNames = new ArrayList<>();
    Map<String, Object> beans = new HashMap<>();
    Map<String, Object> handlerMethods = new HashMap<>();
    //实例化bean时，用来加密Key的字符
    private final String beanKeySecret = "-";

    public DispatcherServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        //1.spring mvc 包扫描
        scanPackage("com.spring.mvc");
        for (String name : classNames) {
            System.out.println("文件名：" + name);
        }

        //2.实例化对象
        classInstance();

        //3.依赖注入，完成装配
        inject();

        //4.url 和 Controller 中的method关系映射
        handlerMapping();
    }

    //url 和 Controller 中的method关系映射
    private void handlerMapping() {
        if (beans.isEmpty()) {
            System.out.println("没有实例化的类");
            return;
        }
        for (Map.Entry<String, Object> map : beans.entrySet()) {
            //集合中获取类实例
            Object instance = map.getValue();
            if (instance.getClass().isAnnotationPresent(Controller.class)) {
                RequestMapping requestMapping = instance.getClass().getAnnotation(RequestMapping.class);
                //获取类上的requestMapping中的路径值  @RequestMapping("/test")
                String path = StringUtils.isEmpty(requestMapping) ? null : requestMapping.value();
                //获取类中所有方法成员属性
                Method[] methods = instance.getClass().getMethods();
                for (Method method : methods) {
                    RequestMapping methodMapping = method.getAnnotation(RequestMapping.class);
                    if (methodMapping != null) {
                        //获取方法上的requestMapping中的路径值  @RequestMapping("/index")
                        String value = methodMapping.value();
                        //类上RequestMapping + 方法上RequestMapping："/test" + "/value"
                        String mappingPath = StringUtils.isEmpty(path) ? value : path + value;
                        handlerMethods.put(mappingPath, method);
                    }
                }
            }
        }
    }

    //依赖注入，完成装配
    private void inject() {
        if (beans.isEmpty()) {
            System.out.println("没有实例化的类");
            return;
        }
        for (Map.Entry<String, Object> map : beans.entrySet()) {
            //集合中获取类实例
            Object instance = map.getValue();
            //获取类中的所有属性
            Field[] fields = instance.getClass().getDeclaredFields();
            for (Field field : fields) {
                //判断成员属性上是否有注解Autowired
                if (field.isAnnotationPresent(Autowired.class)) {
//                    Autowired autowired = field.getAnnotation(Autowired.class);
//                    String value = autowired.value();

                    //获取被注解的类
                    Class clazz = field.getType();
                    Service service = (Service) clazz.getAnnotation(Service.class);
                    String value = service.value();
                    //生成bean对象的key
                    String beanKey = StringUtils.isEmpty(value) ? String.valueOf(clazz.hashCode()) : String.valueOf(clazz.hashCode()) + beanKeySecret + value;

                    field.setAccessible(true);
                    try {
                        //最关键的地方，完成依赖注入
                        field.set(instance, beans.get(beanKey));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //实例化对象
    private void classInstance() {
        if (classNames.isEmpty()) {
            System.out.println("没有扫描到任何类");
            return;
        }
        for (String name : classNames) {
            String realName = name.replace(".class", "");
            try {
                Class clazz = Class.forName(realName);
                //判断这个类是不是Controller类
                if (clazz.isAnnotationPresent(Controller.class)) {
//                    Controller controller = (Controller) clazz.getAnnotation(Controller.class);
                    //完成Controller实例化
                    Object instance = clazz.newInstance();
                    RequestMapping requestMapping = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
                    //如果类上面没有RequestMapping，那么就用类的hashCode作为键（key）
                    String mappingValue = StringUtils.isEmpty(requestMapping) ? String.valueOf(clazz.hashCode()) : clazz.hashCode() + beanKeySecret + requestMapping.value();
                    //把类的映射和类的实例绑定
                    beans.put(mappingValue, instance);
                }
                if (clazz.isAnnotationPresent(Service.class)) {
                    Service service = (Service) clazz.getAnnotation(Service.class);
                    //完成Controller实例化
                    Object instance = clazz.newInstance();
                    //如果类上面没有value，那么就用类的hashCode作为键（key）
                    String value = StringUtils.isEmpty(service.value()) ? String.valueOf(clazz.hashCode()) : clazz.hashCode() + beanKeySecret + service.value();
                    //把类的映射和类的实例绑定
                    beans.put(value, instance);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    //包扫描
    private void scanPackage(String basePackage) {
        //把路径中的.替换成符号“/”
        String path = basePackage.replaceAll("\\.", "/");
        URL url = getClass().getClassLoader().getResource("/" + path);
        System.out.println("url:" + getClass().getClassLoader().getResource("/"));
        //目录递归扫描
        String filePath = url.getFile();
        System.out.println("filePath:" + filePath);
        File[] files = new File(filePath).listFiles();
        for (File file : files) {
            //判断是不是目录
            if (file.isDirectory()) {
                System.out.println(file.getPath());
                scanPackage(basePackage + "." + file.getName());
            } else {
                //类是以.分隔
                classNames.add(basePackage + "." + file.getName());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().append("Served at:").append(req.getContextPath());
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = uri.replaceAll(contextPath, "");

        //获取映射的方法
        Method method = (Method) handlerMethods.get(path);
        if (!StringUtils.isEmpty(method)) {
            //获取当前映射方法所在的类（注意用法，一个表示底层成员声明类的对象）
            Class clazz = method.getDeclaringClass();
            String hashcode = String.valueOf(clazz.hashCode());
            //获取类映射的对象
            RequestMapping requestMapping = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            //生成bean的key
            String beanKey = StringUtils.isEmpty(requestMapping) ? hashcode : (StringUtils.isEmpty(requestMapping.value()) ? hashcode : hashcode + beanKeySecret + requestMapping.value());
            //获取bean对应的实例对象
            Object instance = beans.get(beanKey);
            try {
                Object object = method.invoke(instance, null);
                resp.getWriter().write(object.toString());
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
