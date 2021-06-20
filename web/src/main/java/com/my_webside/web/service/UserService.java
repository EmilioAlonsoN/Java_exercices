package com.my_webside.web.service;

import com.my_webside.web.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> userlist();

    Optional<Users> findOne(Long id);

    Users addUser(Users user);

    String deleteUser(Long id);
}
