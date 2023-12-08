package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.exception.NotFoundException;
import com.siproj.ensias.internship.model.Tuteur;
import com.siproj.ensias.internship.repository.TuteurRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TuteurServiceImpl implements TuteurService {

  private final TuteurRepository tuteurRepository;

  @Override
  public List<Tuteur> getAll() {
    return tuteurRepository.findAll();
  }

  @Override
  public Tuteur addTuteur(Tuteur tuteur) {
    return tuteurRepository.save(tuteur);
  }

  @Override
  public Tuteur getTuteur(Long id) {
    return tuteurRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Tuteur with id " + id + " not found")
      );
  }

  @Override
  public void deleteTuteur(Long id) {
    tuteurRepository.deleteById(id);
  }

  @Override
  public Tuteur updateTuteur(Long id, Tuteur newtuteur) {
    Tuteur oldtuteur = tuteurRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Tuteur with id " + id + " not found")
      );
    oldtuteur.setIdentifiant(newtuteur.getIdentifiant());
    oldtuteur.setTel(newtuteur.getTel());
    return tuteurRepository.save(oldtuteur);
  }
}
