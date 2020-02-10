package com.example.demo.controller;


import com.example.demo.domain.Dishes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.repos.DishesRepo;

import java.util.Map;


@Controller

public class PrivateController {
    @Autowired
    private DishesRepo dishesRepo;


    @GetMapping("/cabinet")
    public String privateCabinet(Map<String, Object> model) {

        Long as = 2L;

        Iterable<Dishes> dishes = dishesRepo.findAll();

        System.out.println(dishes);

        Iterable<Dishes> dishes1 = dishesRepo.findOneById(2L);

        Iterable<Dishes> dishes2 = dishesRepo.findAll();

        model.put("dishes1", dishes1);

        model.put("dishes", dishes);

        model.put("dishes2", dishes2);

        return "cabinet";
    }
}
