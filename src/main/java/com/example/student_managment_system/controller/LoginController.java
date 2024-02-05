package com.example.student_managment_system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cms/login")
public class LoginController {

    @PostMapping
    public void checkLogin(@RequestParam String userName, @RequestParam String password) {

    }

}
