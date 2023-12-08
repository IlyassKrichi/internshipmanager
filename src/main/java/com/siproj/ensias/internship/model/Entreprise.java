package com.siproj.ensias.internship.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Entreprise {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JsonBackReference
  @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
  private List<Stage> stages;

  private String nom;

  private String adresse;

  private String formeJuridique;

  private String telStandard;

  private String telContact;

  private String telTuteur;
}
