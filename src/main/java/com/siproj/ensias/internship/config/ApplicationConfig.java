package com.siproj.ensias.internship.config;

import com.siproj.ensias.internship.model.Etudiant;
import com.siproj.ensias.internship.repository.EtudiantRepository;
import com.siproj.ensias.internship.repository.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

  public final EtudiantRepository etudiantRepository;

  public final ProfesseurRepository professeurRepository;

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> {
      Optional<Etudiant> etudiant = etudiantRepository.findByEmail(username);
      if (etudiant.isPresent()) {
        return etudiant.get();
      } else {
        return professeurRepository
                .findByEmail(username);
      }
    };
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(
    AuthenticationConfiguration config
  ) throws Exception {
    return config.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
