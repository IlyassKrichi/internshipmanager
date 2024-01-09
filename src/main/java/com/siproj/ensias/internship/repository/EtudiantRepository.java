package com.siproj.ensias.internship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siproj.ensias.internship.model.Etudiant;

import java.util.Optional;


public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    @Override
    Optional<Etudiant> findById(Long aLong);

    Optional<Etudiant> findByEmail(String email);
}