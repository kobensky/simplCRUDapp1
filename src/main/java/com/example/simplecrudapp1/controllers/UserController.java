package com.example.simplecrudapp1.controllers;

import com.example.simplecrudapp1.api.AddUserReq;
import com.example.simplecrudapp1.response.Response;
import com.example.simplecrudapp1.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        String hello = "Hello, User page. Version: 1.0.0";
        log.info(hello);
        return hello;
    }

    @PostMapping("/adduser")
    public ResponseEntity<Response> addUser(@RequestBody final AddUserReq req) {
        log.info("START endpoint addUser, request: {}", req);
        ResponseEntity<Response> response = userService.addUser(req);
        log.info("END endpoint addUser, response: {}", response);
        return response;
    }

    @GetMapping("/alluser")
    public ResponseEntity<Response> findAllUsers() {
        log.info("START endpoint findAllUsers.");
        ResponseEntity<Response> response = userService.findAllUsers();
        log.info("END endpoint findAllUsers.");
        return response;
    }
}
