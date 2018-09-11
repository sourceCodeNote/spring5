package com.step.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
        System.err.printf("%s" , "hello");
        return "hello";
    }

    @RequestMapping("/mvc")
    public String helloMvc() {
        //视图渲染，/WEB-INF/jsps/hello.html
        return "hello";
    }

}
