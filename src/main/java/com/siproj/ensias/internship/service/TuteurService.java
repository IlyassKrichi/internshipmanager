package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.model.Tuteur;
import java.util.List;

public interface TuteurService {
  List<Tuteur> getAll();

  Tuteur addTuteur(Tuteur tuteur);

  Tuteur getTuteur(Long id);

  void deleteTuteur(Long id);

  Tuteur updateTuteur(Long id, Tuteur newtuteur);
}
