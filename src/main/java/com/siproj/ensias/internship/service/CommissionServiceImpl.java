package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.exception.NotFoundException;
import com.siproj.ensias.internship.model.Commission;
import com.siproj.ensias.internship.repository.CommissionRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommissionServiceImpl implements CommissionService {

  private final CommissionRepository commissionRepository;

  @Override
  public List<Commission> getAll() {
    return commissionRepository.findAll();
  }

  @Override
  public Commission addCommission(Commission commission) {
    return commissionRepository.save(commission);
  }

  @Override
  public Commission getCommission(Long id) {
    return commissionRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Commission with id " + id + " not found")
      );
  }

  @Override
  public void deleteCommission(Long id) {
    commissionRepository.deleteById(id);
  }

  @Override
  public Commission updateCommission(Long id, Commission newcommission) {
    Commission oldcommission = commissionRepository
      .findById(id)
      .orElseThrow(() ->
        new NotFoundException("Commission with id " + id + " not found")
      );
    oldcommission.setDateRevue(newcommission.getDateRevue());
    return commissionRepository.save(oldcommission);
  }
}
