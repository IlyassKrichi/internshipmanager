package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.model.Promotion;
import java.util.List;

public interface PromotionService {
  List<Promotion> getAll();

  Promotion addPromotion(Promotion promotion);

  Promotion getPromotion(Long id);

  void deletePromotion(Long id);

  Promotion updatePromotion(Long id, Promotion newpromotion);
}
