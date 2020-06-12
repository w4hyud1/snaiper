package com.tiket.sniper.controller;

import com.tiket.sniper.model.User;
import com.tiket.sniper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/user")
    public String UserList (Model model){
        model.addAttribute("user", userService.listUser());
        return "user";
    }

    @RequestMapping("/user/create")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "formUser";
    }



}
