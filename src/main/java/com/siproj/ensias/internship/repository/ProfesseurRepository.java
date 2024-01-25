package com.siproj.ensias.internship.repository;

import com.siproj.ensias.internship.model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
  Professeur findByEmail(String email);
}
