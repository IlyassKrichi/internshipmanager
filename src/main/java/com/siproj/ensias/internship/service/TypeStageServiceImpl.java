package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.exception.NotFoundException;
import com.siproj.ensias.internship.model.TypeStage;
import com.siproj.ensias.internship.repository.TypeStageRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TypeStageServiceImpl implements TypeStageService {

  private final TypeStageRepository typestageRepository;

  @Override
  public List<TypeStage> getAll() {
    return typestageRepository.findAll();
  }

  @Override
  public TypeStage addTypeStage(TypeStage typestage) {
    return typestageRepository.save(typestage);
  }

  @Override
  public TypeStage getTypeStage(Long id) {
    return typestageRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("TypeStage with id " + id + " not found")
      );
  }

  @Override
  public void deleteTypeStage(Long id) {
    typestageRepository.deleteById(id);
  }

  @Override
  public TypeStage updateTypeStage(Long id, TypeStage newtypestage) {
    TypeStage oldtypestage = typestageRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("TypeStage with id " + id + " not found")
      );
    oldtypestage.setNom(newtypestage.getNom());
    return typestageRepository.save(oldtypestage);
  }
}
