package com.siproj.ensias.internship.auth;

import com.siproj.ensias.internship.config.JwtService;
import com.siproj.ensias.internship.model.Etudiant;
import com.siproj.ensias.internship.model.Professeur;
import com.siproj.ensias.internship.model.Role;
import com.siproj.ensias.internship.repository.EtudiantRepository;
import com.siproj.ensias.internship.repository.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final EtudiantRepository etudiantRepository;
  private  final ProfesseurRepository professeurRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    if (request.getRole().name() == "ETUDIANT") {
      var etudiant = Etudiant
              .builder()
              .nom(request.getNom())
              .prenom(request.getPrenom())
              .email(request.getEmail())
              .password(passwordEncoder.encode(request.getPassword()))
              .role(Role.ETUDIANT)
              .adresse(request.getAdresse())
              .dateNaissance(request.getDateNaissance())
              .tel(request.getTel())
              .genre(request.getGenre())
              .build();
      etudiantRepository.save(etudiant);
      var jwtToken = jwtService.generateToken(etudiant);
      return AuthenticationResponse.builder().token(jwtToken).build();
    }
    else {
      var prof = Professeur
              .builder()
              .nom(request.getNom())
              .prenom(request.getPrenom())
              .email(request.getEmail())
              .password(passwordEncoder.encode(request.getPassword()))
              .role(Role.PROFESSEUR)
              .adresse(request.getAdresse())
              .tel(request.getTel())
              .build();
      professeurRepository.save(prof);
      var jwtToken = jwtService.generateToken(prof);
      return AuthenticationResponse.builder().token(jwtToken).build();
    }
  }


  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );

    var etudiant = etudiantRepository.findByEmail(request.getEmail());
    if (etudiant.isPresent()) {
      var jwtToken = jwtService.generateToken(etudiant.get());
      return AuthenticationResponse.builder().token(jwtToken).build();
    } else {
      var professeur = professeurRepository.findByEmail(request.getEmail());
      if (professeur!= null ) {
        var jwtToken = jwtService.generateToken(professeur);
        return AuthenticationResponse.builder().token(jwtToken).build();
      } else {
        return AuthenticationResponse.builder().token("INVALID_TOKEN").build();
      }
    }
  }


}
