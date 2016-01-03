package com.daumkakao.localcontents.test.websupport.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * Created by innoc on 15. 8. 29..
 */
@SpringBootApplication
//@Configuration // SpringBootApplication에 포함 되어있음
//@EnableAutoConfiguration // SpringBootApplication에 포함 되어있음
@ComponentScan("com.daumkakao.localcontents")
public class Application {
    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        String beanNames[] = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

    }
}
