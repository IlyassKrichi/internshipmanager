package com.siproj.ensias.internship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siproj.ensias.internship.model.Commission;

public interface CommissionRepository extends JpaRepository<Commission, Long> {

}