package com.siproj.ensias.internship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siproj.ensias.internship.model.Candidature;

public interface CandidatureRepository extends JpaRepository<Candidature, Long> {

}