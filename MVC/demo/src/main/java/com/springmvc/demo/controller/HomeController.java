package com.springmvc.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Hiren");
        model.addAttribute("id", 20);
      

        List<String> names = new ArrayList<>();
        names.add("Hiren");
        names.add("Varun");
        names.add("Raj");
        model.addAttribute("names", names);

        return "home";
    }
}