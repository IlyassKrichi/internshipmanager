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
public class Professeur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String identifiant;

    private String adresse;

    private LocalDate dateEmbauche;

    private String tel;

    private LocalDate dateDepart;

}