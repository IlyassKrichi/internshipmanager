package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.exception.NotFoundException;
import com.siproj.ensias.internship.model.Competence;
import com.siproj.ensias.internship.repository.CompetenceRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompetenceServiceImpl implements CompetenceService {

  private final CompetenceRepository competenceRepository;

  @Override
  public List<Competence> getAll() {
    return competenceRepository.findAll();
  }

  @Override
  public Competence addCompetence(Competence competence) {
    return competenceRepository.save(competence);
  }

  @Override
  public Competence getCompetence(Long id) {
    return competenceRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Competence with id " + id + " not found")
      );
  }

  @Override
  public void deleteCompetence(Long id) {
    competenceRepository.deleteById(id);
  }

  @Override
  public Competence updateCompetence(Long id, Competence newcompetence) {
    Competence oldcompetence = competenceRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Competence with id " + id + " not found")
      );
    oldcompetence.setDescription(newcompetence.getDescription());
    oldcompetence.setLibelle(newcompetence.getLibelle());
    return competenceRepository.save(oldcompetence);
  }
}
