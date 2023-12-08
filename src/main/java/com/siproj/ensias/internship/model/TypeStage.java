package com.siproj.ensias.internship.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TypeStage {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JsonBackReference
  @OneToMany(mappedBy = "typeStage")
  private List<Stage> stages;

  @JsonManagedReference
  @ManyToMany
  @JoinTable(
    name = "necessite",
    joinColumns = @JoinColumn(name = "typeStage_id"),
    inverseJoinColumns = @JoinColumn(name = "competence_id")
  )
  private List<Competence> competences;

  private String nom;
}
