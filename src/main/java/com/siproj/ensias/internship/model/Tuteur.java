package com.siproj.ensias.internship.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Tuteur {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JsonBackReference
  @OneToMany(mappedBy = "tuteur")
  private List<Stage> stages;

  @JsonBackReference
  @ManyToMany
  @JoinTable(
    name = "contacte",
    joinColumns = @JoinColumn(name = "tuteur_id"),
    inverseJoinColumns = @JoinColumn(name = "professeur_id")
  )
  private List<Professeur> professeurs;

  private String nom;

  private String prenom;

  private String tel;
}
