package com.step.demo.spring5;

import org.springframework.stereotype.Repository;

/**
 * 用户测试业务类
 */
/** 注册为spring的组件bean **/
@Repository(value = "userService")
public class UserService {
    /**
     * 测试方法
     *
     * @param name
     *            参数:输入名称
     * @return 返回结果
     */

    private String name;

    public String sayHello(String name) {
        this.name = name;
        return "Hello," + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String sayHI(String name){
        return "HI," + name;
    }
}
