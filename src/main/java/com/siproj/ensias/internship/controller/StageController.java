package com.siproj.ensias.internship.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.siproj.ensias.internship.model.Stage;
import com.siproj.ensias.internship.service.StageService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StageController {

    private final StageService stageService;

    @GetMapping("/api/stages")
    public List<Stage> getAll() {
        return stageService.getAll();
    }

    @PostMapping("/api/stages")
    public Stage addStage(@RequestBody Stage stage) {
        return stageService.addStage(stage);
    }

    @GetMapping("/api/stages/{id}")
    public Stage getStage(@PathVariable Long id) {
        return stageService.getStage(id);
    }

    @DeleteMapping("/api/stages/{id}")
    public void deleteStage(@PathVariable Long id) {
        stageService.deleteStage(id);
    }

    @PutMapping("/api/stages/{id}")
    public Stage updateStage(@PathVariable Long id, @RequestBody Stage newstage) {
        return stageService.updateStage(id, newstage);
    }

}