package com.example.Trainingmanagement.repository;

import com.example.Trainingmanagement.entity.UserData;
import com.example.Trainingmanagement.mapper.UserDataMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDataRepository {
    private final UserDataMapper userDataMapper;
    public UserDataRepository(UserDataMapper userDataMapper){
        this.userDataMapper = userDataMapper;
    }

    public List<UserData> getAllUserData() {
        return userDataMapper.selectAllUserData();
    }

    public void insertUserData(UserData userData) {
       userDataMapper.insertUserData(userData);
    }

     public void deleteUserData(int userDataId) {
        userDataMapper.deleteUserDataById(userDataId);
    }

}
