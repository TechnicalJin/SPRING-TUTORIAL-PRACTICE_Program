package com.springmvc.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.demo.dao.UserDao;
import com.springmvc.demo.model.User;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User saveUser(User user) {
        return userDao.save(user);
    }
}
