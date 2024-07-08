package com.easycar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class TestController {
    @RequestMapping("/test")
        public String test(HttpSession session, HttpServletResponse response)
    {return "test";
    }
}
