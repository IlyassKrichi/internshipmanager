package com.siproj.ensias.internship.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Competence {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToMany
  @JoinTable(
    name = "necessite",
    joinColumns = @JoinColumn(name = "competence_id"),
    inverseJoinColumns = @JoinColumn(name = "typeStage_id")
  )
  private List<TypeStage> typeStages;

  private String libelle;

  private String description;
}
