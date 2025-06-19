package com.example.Trainingmanagement.service;

import org.springframework.stereotype.Service;

import com.example.Trainingmanagement.entity.Training;
import com.example.Trainingmanagement.form.TrainingForm;
import com.example.Trainingmanagement.repository.TrainingRepository;

import java.util.List;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;//TrainingRepositoryをフィールドとして保持
    public TrainingService(TrainingRepository trainingRepository){//コンストラクタでTrainingRepositoryを受け取り、フィールドに設定
        this.trainingRepository = trainingRepository;
    }
    public List<Training> getAllTraining(){//すべてのトレーニングを取得
        return trainingRepository.getAllTraining();
    }
    public void createTraining(TrainingForm trainingForm){
        Training training = new Training();
        training.setTrainingId(trainingForm.getTrainingId());
        training.setPartId(trainingForm.getPartId());
        training.setWorkout(trainingForm.getWorkout());
        training.setSetId(trainingForm.getSetId());
        training.setWorkout(trainingForm.getWorkout());
        training.setRep(trainingForm.getRep());
        training.setWeight(trainingForm.getWeight());
        training.setMemo(trainingForm.getMemo());
        training.setRegistrationDate(trainingForm.getRegistrationDate());
        trainingRepository.insertTraining(training);
    }


    public Training getTrainingById(int trainingId) {
        return trainingRepository.getTrainingById(trainingId);
    }

    
    public void deleteTraining(int trainingId){
        trainingRepository.deleteTraining(trainingId);
    }

    
    public void updateTraining(int trainingId, Training training) {
        if (trainingId != training.getTrainingId()) {
            throw new IllegalArgumentException("Training ID does not match");
        }
        trainingRepository.updateTraining(training);
    }

    
    public List<Training> searchByPartCategory(String partId) {
        return trainingRepository.getSearchTraining(partId);
    }


}
