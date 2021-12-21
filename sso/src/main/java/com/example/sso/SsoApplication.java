package com.example.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//SpringBoot项目的核心注解
//包括三个部分
//@EnableAutoConfiguration:SringBoot根基应用所声明的的依赖来对Spring框架进行自动配置。
// 例如，添加了 spring-boot-starter-web 依赖，会自动添加 Tomcat 和 Spring MVC 的依赖，
// 那么 Spring Boot 会对 Tomcat 和 Spring MVC 进行自动配置。
//SpringBootConfiguration:被标注的类等于在Spring的XML配置文件中，装配所有的bean事物，提供了一个Spring的上下文环境
//@ComponentScan：组件扫描，可自动发现和装配Bean，默认扫描SpringApplication的run方法里面的.class所在的包路径下文件，所以最好将该启动类根包路径下
@SpringBootApplication
@MapperScan("com.example.sso.core.mapper")
public class SsoApplication {

    public static void main(String[] args) {
///SpringApplication.run()启动整个SpringBoot程序
        SpringApplication.run(SsoApplication.class, args);
    }

}
