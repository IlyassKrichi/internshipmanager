package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.exception.NotFoundException;
import com.siproj.ensias.internship.model.Entreprise;
import com.siproj.ensias.internship.repository.EntrepriseRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EntrepriseServiceImpl implements EntrepriseService {

  private final EntrepriseRepository entrepriseRepository;

  @Override
  public List<Entreprise> getAll() {
    return entrepriseRepository.findAll();
  }

  @Override
  public Entreprise addEntreprise(Entreprise entreprise) {
    return entrepriseRepository.save(entreprise);
  }

  @Override
  public Entreprise getEntreprise(Long id) {
    return entrepriseRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Entreprise with id " + id + " not found")
      );
  }

  @Override
  public void deleteEntreprise(Long id) {
    entrepriseRepository.deleteById(id);
  }

  @Override
  public Entreprise updateEntreprise(Long id, Entreprise newentreprise) {
    Entreprise oldentreprise = entrepriseRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Entreprise with id " + id + " not found")
      );
    oldentreprise.setAdresse(newentreprise.getAdresse());
    oldentreprise.setFormeJuridique(newentreprise.getFormeJuridique());
    oldentreprise.setNom(newentreprise.getNom());
    oldentreprise.setTelContact(newentreprise.getTelContact());
    oldentreprise.setTelStandard(newentreprise.getTelStandard());
    oldentreprise.setTelTuteur(newentreprise.getTelTuteur());
    return entrepriseRepository.save(oldentreprise);
  }
}
