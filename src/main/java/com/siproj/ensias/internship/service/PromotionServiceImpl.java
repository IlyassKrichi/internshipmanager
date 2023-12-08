package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.exception.NotFoundException;
import com.siproj.ensias.internship.model.Promotion;
import com.siproj.ensias.internship.repository.PromotionRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PromotionServiceImpl implements PromotionService {

  private final PromotionRepository PromotionRepository;

  @Override
  public List<Promotion> getAll() {
    return PromotionRepository.findAll();
  }

  @Override
  public Promotion addPromotion(Promotion promotion) {
    return PromotionRepository.save(promotion);
  }

  @Override
  public Promotion getPromotion(Long id) {
    return PromotionRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Promotion with id " + id + " not found")
      );
  }

  @Override
  public void deletePromotion(Long id) {
    PromotionRepository.deleteById(id);
  }

  @Override
  public Promotion updatePromotion(Long id, Promotion newpromotion) {
    Promotion oldpromotion = PromotionRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Promotion with id " + id + " not found")
      );
    oldpromotion.setAnnee(newpromotion.getAnnee());
    oldpromotion.setEtudiantsReussis(newpromotion.getEtudiantsReussis());
    oldpromotion.setTotalEtudiants(newpromotion.getTotalEtudiants());
    return PromotionRepository.save(oldpromotion);
  }
}
