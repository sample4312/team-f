package com.example.Trainingmanagement.repository;

import com.example.Trainingmanagement.entity.User;
import com.example.Trainingmanagement.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final UserMapper userMapper;
    public UserRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    public void insertUser(User user){
        userMapper.insertUser(user);
    }


}