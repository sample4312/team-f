package com.example.Trainingmanagement.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import com.example.Trainingmanagement.entity.Training;
import org.apache.ibatis.annotations.Delete;
import java.util.List;

import org.apache.ibatis.annotations.Update;

@Mapper
public interface TrainingMapper {
    @Select("SELECT training.*, partCategory.partName FROM training JOIN partCategory ON partCategory.partId = training.partId ORDER BY registrationDate ASC;")
    List<Training> selectAllTraining();

    @Insert("INSERT INTO training (partId, workout, registrationDate, setId, rep, weight, memo) VALUES (#{partId}, #{workout}, #{registrationDate}, #{setId}, #{rep}, #{weight}, #{memo})")
    @Options(useGeneratedKeys = true, keyProperty = "trainingId")
    void insertTraining(Training training);

    @Select("SELECT training.*, partCategory.partName, setCategory.setName FROM training JOIN partCategory ON partCategory.partId = training.partId JOIN setCategory ON setCategory.setId = training.setId WHERE trainingId = #{trainingId}")
    Training selectTrainingById(long trainingId);

    @Delete("DELETE FROM training WHERE trainingId = #{trainingId}")
    void deleteTrainingById(long trainingId);

    @Update("UPDATE training SET partId = #{partId}, workout = #{workout}, registrationDate = #{registrationDate}, setId = #{setId}, rep = #{rep}, weight = #{weight}, memo = #{memo} WHERE trainingId = #{trainingId}")
    void updateTraining(Training training); 
    
    @Select("SELECT training.*, partCategory.partName FROM training JOIN partCategory ON partCategory.partId = training.partId WHERE training.partId = #{partId} ORDER BY registrationDate ASC")
    List<Training> selectTrainingByPartCategory(String partId);

}