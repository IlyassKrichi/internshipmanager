package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.model.Competence;
import java.util.List;

public interface CompetenceService {
  List<Competence> getAll();

  Competence addCompetence(Competence competence);

  Competence getCompetence(Long id);

  void deleteCompetence(Long id);

  Competence updateCompetence(Long id, Competence newcompetence);
}
