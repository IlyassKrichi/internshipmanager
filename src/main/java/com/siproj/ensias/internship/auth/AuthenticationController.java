package com.siproj.ensias.internship.auth;

import com.siproj.ensias.internship.model.Etudiant;
import com.siproj.ensias.internship.model.Stage;
import com.siproj.ensias.internship.service.EtudiantService;
import com.siproj.ensias.internship.service.StageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

  private final AuthenticationService service;

  private final EtudiantService etudiantService;

  private final StageService stageService;

  @PostMapping("/auth/register")
  public ResponseEntity<AuthenticationResponse> register(
    @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }

  @PostMapping("/auth/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
    @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @GetMapping("/etudiant/{email}")
  public ResponseEntity<Etudiant> getEtudiantbyEmail(
    @PathVariable String email
  ) {
    return ResponseEntity.ok(etudiantService.getEtudiantByEmail(email));
  }

  @GetMapping("/stages/{id}")
  public ResponseEntity<Stage> getStagesById(@PathVariable Long id) {
    return ResponseEntity.ok(stageService.getStage(id));
  }
}
