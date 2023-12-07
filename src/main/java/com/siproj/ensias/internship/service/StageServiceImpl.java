package com.siproj.ensias.internship.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siproj.ensias.internship.exception.NotFoundException;
import com.siproj.ensias.internship.model.Stage;
import com.siproj.ensias.internship.repository.StageRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StageServiceImpl implements StageService {

    private final StageRepository stageRepository;

    @Override
    public List<Stage> getAll() {
        return stageRepository.findAll();
    }

    @Override
    public Stage addStage(Stage stage) {
        return stageRepository.save(stage);
    }

    @Override
    public Stage getStage(Long id) {
        return stageRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Stage with id " + id + " not found"));
    }

    @Override
    public void deleteStage(Long id) {
        stageRepository.deleteById(id);
    }

    @Override
    public Stage updateStage(Long id, Stage newstage) {
        Stage oldstage = stageRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Stage with id " + id + " not found"));
        oldstage.setDateDebut(newstage.getDateDebut());
        oldstage.setDateFin(newstage.getDateFin());
        return stageRepository.save(oldstage);

    }

}