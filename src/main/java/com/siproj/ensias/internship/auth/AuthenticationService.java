package com.siproj.ensias.internship.auth;

import com.siproj.ensias.internship.config.JwtService;
import com.siproj.ensias.internship.model.Etudiant;
import com.siproj.ensias.internship.model.Role;
import com.siproj.ensias.internship.repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final EtudiantRepository etudiantRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
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

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getPassword()
      )
    );
    var user = etudiantRepository.findByEmail(request.getEmail()).orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder().token(jwtToken).build();
  }
}
