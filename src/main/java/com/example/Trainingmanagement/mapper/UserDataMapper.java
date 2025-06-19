package com.example.Trainingmanagement.mapper;

import com.example.Trainingmanagement.entity.UserData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

@Mapper
public interface UserDataMapper {

    @Select("SELECT userData.* FROM userData ORDER BY registrationDate ASC;")
    List<UserData> selectAllUserData();

    @Insert("INSERT INTO userData (hHeight, hWeight, bmi, registrationDate) VALUES (#{hHeight}, #{hWeight}, #{bmi}, #{registrationDate})")
    @Options(useGeneratedKeys = true, keyProperty = "userDataId")
    void insertUserData(UserData userData);

    @Delete("DELETE FROM userData WHERE userDataId = #{userDataId}")
    void deleteUserDataById(long userDataId);

    
    
}
