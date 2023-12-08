package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.model.Commission;
import java.util.List;

public interface CommissionService {
  List<Commission> getAll();

  Commission addCommission(Commission commission);

  Commission getCommission(Long id);

  void deleteCommission(Long id);

  Commission updateCommission(Long id, Commission newcommission);
}
