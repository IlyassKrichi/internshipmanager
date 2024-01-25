package com.siproj.ensias.internship.auth;

import com.siproj.ensias.internship.model.Genre;
import com.siproj.ensias.internship.model.Promotion;
import com.siproj.ensias.internship.model.Role;
import com.siproj.ensias.internship.model.Stage;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String nom;

  private String prenom;

  private String adresse;

  private LocalDate dateNaissance;

  private String password;

  @Enumerated(EnumType.STRING)
  private Genre genre;

  private String tel;

  private String email;
@Enumerated(EnumType.STRING)
  private Role role;
}
