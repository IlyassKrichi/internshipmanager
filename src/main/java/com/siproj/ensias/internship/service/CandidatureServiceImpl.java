package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.exception.NotFoundException;
import com.siproj.ensias.internship.model.Candidature;
import com.siproj.ensias.internship.repository.CandidatureRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CandidatureServiceImpl implements CandidatureService {

  private final CandidatureRepository CandidatureRepository;

  @Override
  public List<Candidature> getAll() {
    return CandidatureRepository.findAll();
  }

  @Override
  public Candidature addCandidature(Candidature candidature) {
    return CandidatureRepository.save(candidature);
  }

  @Override
  public Candidature getCandidature(Long id) {
    return CandidatureRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Candidature with id " + id + " not found")
      );
  }

  @Override
  public void deleteCandidature(Long id) {
    CandidatureRepository.deleteById(id);
  }

  @Override
  public Candidature updateCandidature(Long id, Candidature newcandidature) {
    Candidature oldcandidature = CandidatureRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Candidature with id " + id + " not found")
      );
    oldcandidature.setInfoSupp(newcandidature.getInfoSupp());
    oldcandidature.setPaiementConf(newcandidature.isPaiementConf());
    oldcandidature.setStatus(newcandidature.getStatus());
    return CandidatureRepository.save(oldcandidature);
  }
}
