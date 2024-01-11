package com.siproj.ensias.internship.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Etudiant {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JsonBackReference
  @ManyToMany
  @JoinTable(
    name = "effectue",
    joinColumns = @JoinColumn(name = "etudiant_id"),
    inverseJoinColumns = @JoinColumn(name = "stage_id")
  )
  private List<Stage> stages;

  @JsonManagedReference
  @ManyToOne(optional = true)
  @JoinColumn(name = "promotion_id", referencedColumnName = "id")
  private Promotion promotion;

  private String nom;

  private String prenom;

  private String adresse;

  private LocalDate dateNaissance;

  public void setPassword(String password) {
    this.password = password;
  }

  private String password;

  private enum genre {
    MASCULIN,
    FEMININ,
  }

  @Enumerated(EnumType.STRING)
  private genre genre;

  private String tel;

  private String email;
}
