package com.example.demo.controller;


import com.example.demo.domain.Dishes;
import com.example.demo.domain.User;
import com.example.demo.repos.DishesRepo;
import com.sun.xml.bind.v2.model.core.ID;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Id;
import java.util.Map;

@Controller
public class DishesController {
    @Autowired
    private DishesRepo dishesRepo;


    @GetMapping("/dishes")
    public String dishes(Map<String, Object> model) {
        Iterable<Dishes> dishes =  dishesRepo.findAll();


        model.put("dishes", dishes);

        return "dishes";

    }

    @PostMapping("/dishes")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String name, @RequestParam String composition, @RequestParam String nutrients, Map<String, Object> model) {
        Dishes dishe = new Dishes(name, composition, nutrients, user);

        dishesRepo.save(dishe);

        Iterable<Dishes> dishes =  dishesRepo.findAll();

        model.put("dishes", dishes);
        return "dishes";
    }


    @GetMapping("/dishes/filter")
    public String getDishes(Map<String, Object> model) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Long count  = dishesRepo.count();


            Iterable<Dishes> dishes = dishesRepo.findAll();



            model.put("dishes", dishes);



        return "filter";
    }
}
