package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.model.TypeStage;
import java.util.List;

public interface TypeStageService {
  List<TypeStage> getAll();

  TypeStage addTypeStage(TypeStage typestage);

  TypeStage getTypeStage(Long id);

  void deleteTypeStage(Long id);

  TypeStage updateTypeStage(Long id, TypeStage newtypestage);
}
