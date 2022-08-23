package com.n9.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Service1Controller {

    @Autowired
    private RestTemplate restTemplate;



    @RequestMapping("/hello")
    public ResponseEntity<String> hello() {
        return restTemplate.getForEntity("http://MS23/micro/hello", String.class);
    }
}
