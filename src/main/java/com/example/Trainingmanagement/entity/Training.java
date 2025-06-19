package com.example.Trainingmanagement.entity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class Training {
    private int trainingId;//トレーニングID
    private String partId;//部位ID
    private String workout;//種目
    private String memo;//メモ
    private String setId;//セットID
    private Long rep;//レップ数
    private Double weight;//重量

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;//登録日
    private LocalDateTime createdAt;

    private String partName;//部位名称
    private String setName;//セット回数

}