package com.siproj.ensias.internship.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String dureeStage;

    private LocalDate dateDebut;

    private LocalDate dateFin;

}