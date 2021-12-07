package com.example.Controller;

import com.example.Domain.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestParam String login, @RequestParam String password, Model model) {
        userService.addUser(login,password);
        return "something.html"; //здесь должно быть что то типа return "login.html"
    }
    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password) {
        User user = userService.login(login, password);
        if (user != null)
            return ""; // Если пользователь найден (не null) тогда возвращаем view return "main.html" - главная страница
        else
            return ""; // если пользователь НЕ найден (null) тогда возвращаем на форму логина return "login.html"

    }


}
