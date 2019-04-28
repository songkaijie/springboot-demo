package com.rm.example.demo.repository;

import com.rm.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/22
 */
@Mapper
@Component
public interface UserMapper {
    @Select({"select *  from book_user "})
    List<User> getUsers();
}
