package com.spring.mvc.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mr.PanYang on 2018/5/18.
 */
public class Proxy {

    private static final Logger logger = LoggerFactory.getLogger(Proxy.class);

    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        logger.info("ValidationAspect this method " + methodName + " begin. param<" + args + ">");
    }

    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("ValidationAspect this method " + methodName + " end.");
    }

    public Object aroundMethod(ProceedingJoinPoint point) {
        Object result;
        String methodName = point.getSignature().getName();
        try {
            //前置通知
            System.out.println("The method " + methodName + " start. param<" + Arrays.asList(point.getArgs()) + ">");
            //执行目标方法
            result = point.proceed();
            //返回通知
            System.out.println("The method " + methodName + " end. result<" + result + ">");
        } catch (Throwable e) {
            //异常通知
            System.out.println("this method " + methodName + " end.ex message<" + e + ">");
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("The method " + methodName + " end.");
        return result;
    }

//    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
    // 加逻辑的时候, 不要依赖执行的的先后顺序
//		System.out.println("method around start!");
//		org.aspectj.lang.Signature signature = pjp.getSignature();
//		Object[] obs = pjp.getArgs();
//		org.aspectj.lang.JoinPoint.StaticPart part = pjp.getStaticPart();
//		Object o = pjp.getTarget();
//		System.out.println("methodName:"+o.getClass().getName()+"."+pjp.getSignature().getName());
//        return pjp.proceed();
//		System.out.println("method around end!");
//    }

}
