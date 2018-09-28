package com.alex.bunny.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut(value = "execution(public * com.alex.bunny.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void goBefore(JoinPoint joinPoint){
        logger.info("before.........");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // url
        logger.info("URL={}", request.getRequestURL());
        // method
        logger.info("METHOD={}", request.getMethod());
        // ip
        logger.info("IP={}", request.getRemoteAddr());
        // 类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        // 参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void goAfter(){
        logger.info("after.........");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}", object.toString());
    }

}
