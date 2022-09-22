package com.example.itmoweb2.service.impl;

import com.example.itmoweb2.dao.abst.UserRepository;
import com.example.itmoweb2.dao.impl.UserDAO;
import com.example.itmoweb2.model.user.User;
import com.example.itmoweb2.service.abst.UserService;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserDAO();

    @Override
    public User getUser(Long id) {
        return userRepository.getUser(id);
    }
}
