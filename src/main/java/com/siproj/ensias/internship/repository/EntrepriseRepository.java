package com.siproj.ensias.internship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siproj.ensias.internship.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

}