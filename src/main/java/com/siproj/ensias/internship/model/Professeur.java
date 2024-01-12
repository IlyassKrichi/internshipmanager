package com.siproj.ensias.internship.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Professeur implements UserDetails {

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

  private String nom;

  private String password;

  private String prenom;

  private String adresse;


  private LocalDate dateEmbauche;

  private String tel;

  private String email;

  private LocalDate dateDepart;

  @Enumerated(EnumType.STRING)
  private Role role=Role.PROFESSEUR;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
