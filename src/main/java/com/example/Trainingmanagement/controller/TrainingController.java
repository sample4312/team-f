package com.example.Trainingmanagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Trainingmanagement.entity.Training;
import com.example.Trainingmanagement.form.TrainingForm;
import com.example.Trainingmanagement.service.TrainingService;

import com.example.Trainingmanagement.entity.UserData;
import com.example.Trainingmanagement.service.UserDataService;
import com.example.Trainingmanagement.form.UserDataForm;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import java.util.List;
@Controller
@RequestMapping("/training")
public class TrainingController {
    private final TrainingService trainingService;
    private final UserDataService userDataService;

    public TrainingController(TrainingService trainigService, UserDataService userDataService) {
        this.trainingService = trainigService;
        this.userDataService = userDataService;
    }

    @GetMapping
    public String training(Model model) {//全てのトレーニングを取得して、リストとして表示
        List<Training> training = trainingService.getAllTraining();
        model.addAttribute("training", training);
        return "training/training-list";
    }

    @GetMapping("/new")
    public String TrainingForm(Model model) {//新しいトレーニングを作成するためのフォームを表示
        TrainingForm trainingForm = new TrainingForm();
        model.addAttribute("trainingForm", trainingForm);
        return "training/training-form";
    }
    @PostMapping("/new")
    public String createTraining(@Valid TrainingForm trainingForm, BindingResult result) {//新しいトレーニングをデータベースに追加する
        //List<Album> albums = albumService.getAllAlbums();
        //model.addAttribute("albums", albums);
        if(result.hasErrors()){
            return "training/training-form";
        }else{
            trainingService.createTraining(trainingForm);
            return "redirect:/training";
        }
    }

    @GetMapping("/{trainingId}")
    public String training(@PathVariable int trainingId, Model model){
        Training training = trainingService.getTrainingById(trainingId);
        model.addAttribute("training", training);
        return "training/training-detail";
    }

    @PostMapping("/{trainingId}/deleteTraining")
    public String deleteTraining(@PathVariable int trainingId) {
        trainingService.deleteTraining(trainingId);
        return "redirect:/training";
    }

    @GetMapping("/{trainingId}/edit")
    public String edittraining(@PathVariable int trainingId, Model model){
        Training training = trainingService.getTrainingById(trainingId);
        model.addAttribute("training", training);
        return "training/training-edit";
    }
    
    @PostMapping("/{trainingId}/edit")
    public String updateTraining(@PathVariable int trainingId, Training training,@Valid TrainingForm trainingForm, BindingResult result){
        if(result.hasErrors()){
            return "training/training-edit";
        }else{
            trainingService.updateTraining(trainingId, training);
            return "redirect:/training";
        }
        
    }

    @GetMapping("/userData")
    public String userData(Model model) {//全てのトレーニングを取得して、リストとして表示
        List<UserData> userData = userDataService.getAllUserData();
        model.addAttribute("userData", userData);
        return "training/user-list";
    }

    @GetMapping("/newuser")
    public String UserDataForm(Model model) {//新しいトレーニングを作成するためのフォームを表示
        UserDataForm userDatagForm = new UserDataForm();
        model.addAttribute("userDataForm", userDatagForm);
        return "training/user-form";
    }

    @PostMapping("/newuser")
    public String createUserData(@Valid UserDataForm userDatagForm, BindingResult result) {//新しいトレーニングをデータベースに追加する
        //List<Album> albums = albumService.getAllAlbums();
        //model.addAttribute("albums", albums);
        if(result.hasErrors()){
            return "training/user-form";
        }else{
            userDataService.createUserData(userDatagForm);
            return "redirect:/training/userData";
        }
    }

    @PostMapping("/{userDataId}/deleteUser")
    public String deleteUserData(@PathVariable int userDataId) {
        userDataService.deleteUserData(userDataId);
        return "redirect:/training/userData";
    }
    
    @Controller
    @RequestMapping("/chart")
    public class ChartController {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @GetMapping
        @ResponseBody
        public Map<String, Object> getWeightData() {
            String sql = "SELECT hWeight, registrationDate FROM userData ORDER BY registrationDate ASC";
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

            List<Double> weights = new ArrayList<>();
            List<String> dates = new ArrayList<>();

            for (Map<String, Object> row : rows) {
                weights.add((Double) row.get("hWeight"));
                dates.add(row.get("registrationDate").toString());
            }

            Map<String, Object> response = new HashMap<>();
            response.put("weights", weights);
            response.put("dates", dates);

            return response;
        }

    }

    @GetMapping("/search")
    public String searchByPartCategory(@RequestParam String partId, Model model) {
        List<Training> training = trainingService.searchByPartCategory(partId);
        model.addAttribute("training", training);
        return "training/training-list";
    }

}