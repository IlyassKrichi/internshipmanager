package com.siproj.ensias.internship.repository;

import com.siproj.ensias.internship.model.Stage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StageRepository extends JpaRepository<Stage, Long> {
  @Query("SELECT s FROM Stage s JOIN s.etudiants e WHERE e.email = ?1")
  List<Stage> findByEmail(String email);
}
