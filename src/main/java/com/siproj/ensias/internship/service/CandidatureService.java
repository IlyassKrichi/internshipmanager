package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.model.Candidature;
import java.util.List;

public interface CandidatureService {
  List<Candidature> getAll();

  Candidature addCandidature(Candidature candidature);

  Candidature getCandidature(Long id);

  void deleteCandidature(Long id);

  Candidature updateCandidature(Long id, Candidature newcandidature);
}
