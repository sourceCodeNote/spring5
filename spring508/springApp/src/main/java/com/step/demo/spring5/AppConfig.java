package com.step.demo.spring5;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 创建spring5的Java配置文件
 *
 * @author
 *
 */
@Configuration
/** 该注解表示这个类是一个Spring的配置类 **/
@ComponentScan(basePackages = {"com.step.demo.spring5" }) /*** 该注解表示启用spring的组件扫描功能，并且配置了扫描包net.xqlee.project.demo下的所有类 **/
public class AppConfig {

}
