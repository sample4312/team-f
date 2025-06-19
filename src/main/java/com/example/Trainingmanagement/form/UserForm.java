package com.example.Trainingmanagement.form;

import lombok.Data;

import jakarta.validation.constraints.Size;
//import io.micrometer.common.util.StringUtils;
import jakarta.validation.constraints.Pattern;
@Data
public class UserForm {
    @Size(min = 1, max = 100, message = "正しく入力してください")
    private String username;
    @Size(min = 4, max = 100, message = "正しく入力してください")
    @Pattern(regexp="^[0-9a-zA-Z]+$", message = "記号は入力できません")
    private String password;

}
