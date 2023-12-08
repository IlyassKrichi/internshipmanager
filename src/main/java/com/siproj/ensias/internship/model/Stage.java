package com.siproj.ensias.internship.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
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
public class Stage {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "entreprise_id", referencedColumnName = "id")
  private Entreprise entreprise;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "typeStage_id", referencedColumnName = "id")
  private TypeStage typeStage;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "tuteur_id", referencedColumnName = "id")
  private Tuteur tuteur;

  @JsonManagedReference
  @ManyToMany
  @JoinTable(
    name = "effectue",
    joinColumns = @JoinColumn(name = "stage_id"),
    inverseJoinColumns = @JoinColumn(name = "etudiant_id")
  )
  private List<Etudiant> etudiants;

  private LocalDate dateDebut;

  private LocalDate dateFin;
}
