package com.example.simplecrudapp1.controllers;

import com.example.simplecrudapp1.service.SportsClubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("sportsclub")
public class SportsClubController {
/*    @Autowired
    private SportsClubService sportsClubService;*/

    @GetMapping("/hello")
    public String hello() {
        String hello = "Hello, Sports Club page. Version: 1.0.0";
        log.info(hello);
        return hello;
    }

    /* TODO */
}
