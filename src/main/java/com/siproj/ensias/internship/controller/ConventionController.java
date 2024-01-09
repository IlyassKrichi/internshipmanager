package com.siproj.ensias.internship.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/fiches")
public class ConventionController {

    @PostMapping("/submitCS")
    public ResponseEntity<String> soumettreFiche(@RequestParam("fichePDF") MultipartFile fichePDF) {
        // Ajoutez la logique pour traiter la fiche de stage
        // par exemple, enregistrer le fichier, déclencher l'évaluation, etc.
        // Retournez une réponse appropriée
        return ResponseEntity.ok("Fiche de stage soumise avec succès!");
    }
}
