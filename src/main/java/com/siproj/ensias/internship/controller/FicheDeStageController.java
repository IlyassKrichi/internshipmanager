package com.siproj.ensias.internship.controller;


import com.siproj.ensias.internship.service.FicheDeStageServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/fiches")
public class FicheDeStageController {

    FicheDeStageServiceImpl ficheDeStageService;
    @PostMapping("/submitFS")
    public ResponseEntity<String> soumettreFiche(@RequestParam("fichePDF") MultipartFile fichePDF) {
        // Ajoutez la logique pour traiter la fiche de stage: none
        // par exemple, enregistrer le fichier, déclencher l'évaluation, etc.
        ficheDeStageService.saveFile(fichePDF);
        // Retournez une réponse appropriée
        return ResponseEntity.ok("Fiche de stage soumise avec succès!");
    }
}
