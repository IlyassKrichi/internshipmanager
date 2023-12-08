package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.model.Etudiant;
import java.util.List;

public interface EtudiantService {
  List<Etudiant> getAll();

  Etudiant addEtudiant(Etudiant etudiant);

  Etudiant getEtudiant(Long id);

  void deleteEtudiant(Long id);

  Etudiant updateEtudiant(Long id, Etudiant newetudiant);
}
