package com.my_webside.web.service.impl;

import com.my_webside.web.model.Users;
import com.my_webside.web.repository.UserRepository;
import com.my_webside.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> userList() {
        return userRepository.findAll();
    }

    @Override
    public Users findOne(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "{'message': 'User deleted successfully'}";
    }

}
