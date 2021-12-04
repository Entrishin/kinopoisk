package com.example.Controller;

import com.example.Domain.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestParam String login, @RequestParam String password) {
        return userService.addUser(login,password);
    }
    @PostMapping("/login")
    public User login(@RequestParam String login, @RequestParam String password) {
        return userService.login(login,password);
    }


}
