package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.model.Entreprise;
import java.util.List;

public interface EntrepriseService {
  List<Entreprise> getAll();

  Entreprise addEntreprise(Entreprise entreprise);

  Entreprise getEntreprise(Long id);

  void deleteEntreprise(Long id);

  Entreprise updateEntreprise(Long id, Entreprise newentreprise);
}
