package com.example.Trainingmanagement.entity;

import lombok.Data;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class UserData {

    private int userDataId;
    private Double hHeight;//身長
    private Double hWeight;//体重
    private double bmi;//bmi

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;//登録日
    
}
