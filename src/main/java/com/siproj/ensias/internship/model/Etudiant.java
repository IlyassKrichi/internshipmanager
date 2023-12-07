package com.siproj.ensias.internship.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Etudiant {

    private long id;

    private String identifiant;

    private String adresse;

    private LocalDate dateNaissance;

    private enum genre {
        MASCULIN,
        FEMININ
    }

    private genre genre;

    private String tel;

    private float scoreExam;

}