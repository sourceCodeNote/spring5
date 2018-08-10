package com.step.demo.spring5;

import org.springframework.stereotype.Component;

/**
 * 用户测试业务类
 */
@Component
/** 注册为spring的组件bean **/
public class UserService {
    /**
     * 测试方法
     *
     * @param name
     *            参数:输入名称
     * @return 返回结果
     */
    public String sayHello(String name) {
        return "Hello," + name;
    }
}
