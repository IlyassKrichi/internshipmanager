package com.siproj.ensias.internship.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
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

  @JsonManagedReference
  @ManyToMany
  @JoinTable(
    name = "contacte",
    joinColumns = @JoinColumn(name = "professeur_id"),
    inverseJoinColumns = @JoinColumn(name = "tuteur_id")
  )
  private List<Tuteur> tuteurs;

  @JsonManagedReference
  @OneToOne(mappedBy = "professeur", optional = true)
  private Promotion promotion;

  private String identifiant;

  private String adresse;

  private LocalDate dateEmbauche;

  private String tel;

  private LocalDate dateDepart;
}
