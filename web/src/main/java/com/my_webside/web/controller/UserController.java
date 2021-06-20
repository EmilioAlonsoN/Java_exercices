package com.my_webside.web.controller;


import com.my_webside.web.model.Users;
import com.my_webside.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @RequestMapping("/add")
    public Users addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @RequestMapping("/list/{id}")
    public Optional<Users> findOne(@PathVariable Long id) {
        return userService.findOne(id);
    }

    @RequestMapping("/list")
    public List<Users> userList() {
        return userService.userlist();
    }
}
