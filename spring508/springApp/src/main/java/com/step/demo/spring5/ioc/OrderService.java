package com.step.demo.spring5.ioc;

import com.step.demo.spring5.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "orderService")
public class OrderService {

    @Autowired
    private UserService userService;

    public void order(String name){
        System.err.printf("%s下订单\n" ,userService.getName());
    }


}
