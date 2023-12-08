package com.siproj.ensias.internship.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Promotion {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JsonBackReference
  @OneToOne
  private Professeur professeur;

  @JsonBackReference
  @OneToMany(mappedBy = "promotion")
  private List<Etudiant> etudiants;

  private int annee;

  private int totalEtudiants;

  private int etudiantsReussis;
}
