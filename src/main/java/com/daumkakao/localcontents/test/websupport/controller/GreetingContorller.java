package com.daumkakao.localcontents.test.websupport.controller;

import model.Greeting;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by innoc on 15. 8. 29..
 */
@RestController
public class GreetingContorller {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    public static void main(String[] args) throws IOException {
        String url = "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q={query}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String result = restTemplate.getForObject(url,String.class, "Android" );
        ObjectMapper mapper = new ObjectMapper();
        HashMap resultMap = mapper.readValue(result, HashMap.class);

        System.out.println(resultMap);
    }
}
