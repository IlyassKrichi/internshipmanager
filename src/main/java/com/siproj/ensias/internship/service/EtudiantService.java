package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.model.Etudiant;
import java.util.List;

public interface EtudiantService {
  List<Etudiant> getAll();

  Etudiant addEtudiant(Etudiant etudiant);

  void deleteEtudiant(Long id);

  Etudiant updateEtudiant(Long id, Etudiant newetudiant);

  List<Etudiant> getAllEtudiants();

  Etudiant getEtudiantById(Long id);

  Etudiant getEtudiantByEmail(String email);
}
