package com.step.demo.spring5;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring 5程序启动类
 *
 * @author
 */
public class Application {

    /**
     * pointCut
     * Aspect
     * before
     * after
     * around
     * exception
     * */
    @Test
    public void test_aop(){
        // 创建spring 基于注解配置的容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // 获取通过注解注入容器的UserService
        UserService userService = (UserService) context.getBean("userService");
        // 调用userService的方法执行
        String message = userService.sayHello("jack");
        // 输出结果
        System.out.println(message);
        // 关闭容器,释放JVM资源
        context.close();
    }


    /**
     * spring 依赖注入用户测试类
     **/
    @Test
    public void test_start() {
        // 创建spring 基于注解配置的容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // 获取通过注解注入容器的UserService
        UserService userService = context.getBean(UserService.class);
        // 调用userService的方法执行
        String message = userService.sayHello("jack");
        // 输出结果
        System.out.println(message);
        // 关闭容器,释放JVM资源
        context.close();
    }

}
