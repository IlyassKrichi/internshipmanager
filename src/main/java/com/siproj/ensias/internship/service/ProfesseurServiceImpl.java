package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.exception.NotFoundException;
import com.siproj.ensias.internship.model.Professeur;
import com.siproj.ensias.internship.repository.ProfesseurRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfesseurServiceImpl implements ProfesseurService {

  private final ProfesseurRepository professeurRepository;

  @Override
  public List<Professeur> getAll() {
    return professeurRepository.findAll();
  }

  @Override
  public Professeur addProfesseur(Professeur professeur) {
    return professeurRepository.save(professeur);
  }

  @Override
  public Professeur getProfesseur(Long id) {
    return professeurRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Professeur with id " + id + " not found")
      );
  }

  @Override
  public void deleteProfesseur(Long id) {
    professeurRepository.deleteById(id);
  }

  @Override
  public Professeur updateProfesseur(Long id, Professeur newprofesseur) {
    Professeur oldprofesseur = professeurRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Professeur with id " + id + " not found")
      );
    oldprofesseur.setAdresse(newprofesseur.getAdresse());
    oldprofesseur.setDateDepart(newprofesseur.getDateDepart());
    oldprofesseur.setDateEmbauche(newprofesseur.getDateEmbauche());
    oldprofesseur.setNom(newprofesseur.getNom());
    oldprofesseur.setPrenom(newprofesseur.getPrenom());
    oldprofesseur.setTel(newprofesseur.getTel());
    oldprofesseur.setEmail(newprofesseur.getEmail());
    return professeurRepository.save(oldprofesseur);
  }
}
