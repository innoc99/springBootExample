package com.daumkakao.localcontents.test.websupport.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by innoc on 15. 8. 29..
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "Greetings from Spring Boot!";
    }
}
