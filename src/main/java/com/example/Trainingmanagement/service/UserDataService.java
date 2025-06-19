package com.example.Trainingmanagement.service;

import com.example.Trainingmanagement.entity.UserData;
import com.example.Trainingmanagement.repository.UserDataRepository;
import org.springframework.stereotype.Service;
import com.example.Trainingmanagement.form.UserDataForm;

import java.util.List;

@Service
public class UserDataService {

    private final UserDataRepository userDataRepository;

    public UserDataService(UserDataRepository userDataRepository){
        this.userDataRepository = userDataRepository;
    }

    public List<UserData> getAllUserData() {
        return userDataRepository.getAllUserData();
    }

     public void createUserData(UserDataForm userDataForm) {
        UserData userData = new UserData();
        userData.setUserDataId(userDataForm.getUserDataId());
        userData.setHHeight(userDataForm.getHHeight());
        userData.setHWeight(userDataForm.getHWeight());
        userData.setRegistrationDate(userDataForm.getRegistrationDate()); 
        double hHeightInMeters = userData.getHHeight() / 100.0; 
        double bmi = userData.getHWeight() / (hHeightInMeters * hHeightInMeters);
        userData.setBmi(bmi);

        double roundedBmi = Math.round(bmi * 10.0) / 10.0;
        userData.setBmi(roundedBmi);
        
        userDataRepository.insertUserData(userData);  
    }

    public void deleteUserData(int userDataId) {
        userDataRepository.deleteUserData(userDataId);
    }

}
