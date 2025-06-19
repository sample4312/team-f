package com.example.Trainingmanagement.repository;
import org.springframework.stereotype.Repository;

import com.example.Trainingmanagement.entity.Training;
import com.example.Trainingmanagement.mapper.TrainingMapper;

import java.util.List;
@Repository
public class TrainingRepository {
private final TrainingMapper trainingMapper;//TrainingMapperのインスタンス
public TrainingRepository(TrainingMapper trainingMapper) {//コンストラクタでTrainingMapperを受け取る
this.trainingMapper = trainingMapper;
    }
    public List<Training> getAllTraining() {//データベースから全てのトレーニングデータを取得
        return trainingMapper.selectAllTraining();
    }
    public void insertTraining(Training training) {//トレーニングデータをデータベースに挿入
        trainingMapper.insertTraining(training);
    }
    public Training getTrainingById(int trainingId){//トレーニングデータの取得
        return trainingMapper.selectTrainingById(trainingId);
    }
    public void deleteTraining(int Id){//トレーニングデータの削除
        trainingMapper.deleteTrainingById(Id);
    }
    public void updateTraining(Training training){//トレーニングデータのアップデート
        trainingMapper.updateTraining(training);
    }

    public List<Training> getSearchTraining(String partId) {//データベースから全てのトレーニングデータを取得
        return trainingMapper.selectTrainingByPartCategory(partId);
    } 
        
    
}