package com.rm.example.demo.service;

import com.rm.example.demo.entity.User;
import com.rm.example.demo.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/22
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
