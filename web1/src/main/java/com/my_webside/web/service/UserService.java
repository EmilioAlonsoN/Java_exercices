package com.my_webside.web.service;

import com.my_webside.web.model.Users;

import java.util.List;

public interface UserService {
    List<Users> userList();

    Users findOne(Long id);

    Users addUser(Users user);

    String deleteUser(Long id);
}
