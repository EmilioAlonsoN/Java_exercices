package com.my_webside.web.service.impl;

import com.my_webside.web.model.Users;
import com.my_webside.web.repository.UserRepository;
import com.my_webside.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<Users> userlist() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> findOne(Long id) {
        return userRepository.findById(id);
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
