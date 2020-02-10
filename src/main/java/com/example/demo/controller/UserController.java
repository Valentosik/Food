package com.example.demo.controller;


import com.example.demo.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class UserController {
    @GetMapping("/user")
    public String getUserInfo(Map<String, Object> model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.put("user", user);

        return "user";
    }


}
