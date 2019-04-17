package com.yuantu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JINZONGFAN on 2019/4/16 17:41
 */
@RestController
@RequestMapping(value = "/user")
public class ApiController {

    @GetMapping("/test")
    public String Test(){
        return "success";
    }
}
