package com.example.Trainingmanagement.form;
import lombok.Data;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Data
public class TrainingForm {
    private int trainingId;
    private String partId;
    @NotBlank(message = "種目を入力してください")
    @Size(min=0, max= 100, message = "種目は100文字以内で入力してください")
    private String workout;
    @NotNull(message = "日付を入力してください")
    private LocalDate registrationDate;
    private String setId;
    @NotNull(message = "レップ数を入力してください")
    @Positive(message = "レップ数は正の数を入力してください")
    private Long rep;
    private Double weight;
    @Size(min=0, max= 200, message = "メモは200文字以内で入力してください")
    private String memo;

}