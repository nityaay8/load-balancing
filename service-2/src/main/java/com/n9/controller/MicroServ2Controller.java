package com.n9.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("micro")
public class MicroServ2Controller {

    @Value("${server.port}")
    private int port;

    @GetMapping("serv2")
    public ResponseEntity hello(){
        return ResponseEntity.ok("hello from service 2, using the port : "+port);
    }
}
