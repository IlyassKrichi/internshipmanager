package com.siproj.ensias.internship.repository;

import com.siproj.ensias.internship.model.Etudiant;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
  Optional<Etudiant> findByEmail(String email);
}
