package com.springmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import com.springmvc.demo.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import com.springmvc.demo.service.UserService;


@Controller
public class ContactController {

    @Autowired
    private UserService userService;

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

   /*  @PostMapping("/saveContact")
    public String saveContact(HttpServletRequest request) {
        System.out.println("saveContact method called");
    
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        System.out.println(name + " " + email + " " + phone);
        return "contact";
    } */


    // OR
    /* @PostMapping("/saveContact")
    public String saveContact(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("phone") String phone) {
        System.out.println(name + " " + email + " " + phone);
        return "contact";
    } */

    // OR
    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute User user) {
        userService.saveUser(user);
        return "contact";
    }
}