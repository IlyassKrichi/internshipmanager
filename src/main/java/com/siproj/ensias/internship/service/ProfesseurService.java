package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.model.Professeur;
import java.util.List;

public interface ProfesseurService {
  List<Professeur> getAll();

  Professeur addProfesseur(Professeur professeur);

  Professeur getProfesseur(Long id);

  void deleteProfesseur(Long id);

  Professeur updateProfesseur(Long id, Professeur newprofesseur);

  Professeur getProfesseurByEmail(String email);
}
