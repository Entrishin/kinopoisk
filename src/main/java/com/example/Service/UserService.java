package com.example.Service;

import com.example.Domain.User;
import com.example.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public String addUser(String login, String password) {
        User user = new User(login,password);
        userRepo.save(user);
        return "OK";
    }
    public User login(String login,String password) {
        User user = userRepo.findByLogin(login);
        if (user != null) {
            return user;
        } else
        {
            return null;
        }

    }

}
