package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.model.Stage;
import java.util.List;

public interface StageService {
  List<Stage> getAll();

  Stage addStage(Stage stage);

  Stage getStage(Long id);

  void deleteStage(Long id);

  Stage updateStage(Long id, Stage newstage);

  List<Stage> getStagesByEmail(String email);
}
