package com.siproj.ensias.internship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siproj.ensias.internship.model.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}