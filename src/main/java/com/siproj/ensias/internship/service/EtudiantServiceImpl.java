package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.exception.NotFoundException;
import com.siproj.ensias.internship.model.Etudiant;
import com.siproj.ensias.internship.repository.EtudiantRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {

  private final EtudiantRepository etudiantRepository;

  @Override
  public List<Etudiant> getAll() {
    return etudiantRepository.findAll();
  }

  @Override
  public Etudiant addEtudiant(Etudiant etudiant) {
    return etudiantRepository.save(etudiant);
  }

  @Override
  public Etudiant getEtudiant(Long id) {
    return etudiantRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Etudiant with id " + id + " not found")
      );
  }

  @Override
  public void deleteEtudiant(Long id) {
    etudiantRepository.deleteById(id);
  }

  @Override
  public Etudiant updateEtudiant(Long id, Etudiant newetudiant) {
    Etudiant oldetudiant = etudiantRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Etudiant with id " + id + " not found")
      );
    oldetudiant.setAdresse(newetudiant.getAdresse());
    oldetudiant.setDateNaissance(newetudiant.getDateNaissance());
    oldetudiant.setGenre(newetudiant.getGenre());
    oldetudiant.setNom(newetudiant.getNom());
    oldetudiant.setPrenom(newetudiant.getPrenom());
    oldetudiant.setScoreExam(newetudiant.getScoreExam());
    oldetudiant.setTel(newetudiant.getTel());
    oldetudiant.setEmail(newetudiant.getEmail());
    return etudiantRepository.save(oldetudiant);
  }
}
