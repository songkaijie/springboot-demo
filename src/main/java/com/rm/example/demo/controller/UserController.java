package com.rm.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.rm.example.demo.entity.User;
import com.rm.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getRedisValue")
    public String getRedisValue() {
        String value = redisTemplate.opsForValue().get("name").toString();
        Map<String, Object> map = new HashMap<>();
        map.put("name", value);
        return JSON.toJSONString(map);

    }

    @PostMapping("/setRedisValue")
    public String setRedisValue() {
        redisTemplate.opsForValue().set("age", "15");
        Map<String, Object> map = new HashMap<>();
        map.put("data", "ok");
        return JSON.toJSONString(map);
    }
}
