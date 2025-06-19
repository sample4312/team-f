package com.example.Trainingmanagement.form;

import lombok.Data;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

@Data
public class UserDataForm {
    private int userDataId;
    @NotNull(message = "身長を入力してください")
    private Double hHeight;//身長
    @NotNull(message = "体重を入力してください")
    private Double hWeight;//体重
    private double bmi;//bmi
    @NotNull(message = "日付を入力してください")
    private LocalDate registrationDate;//登録日

}
