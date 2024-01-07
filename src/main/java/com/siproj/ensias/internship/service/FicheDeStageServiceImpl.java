package com.siproj.ensias.internship.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FicheDeStageServiceImpl implements FicheDeStageService {

    private static final String UPLOAD_DIR = "/Desktop/fichestage"; // Remplacez par le chemin où vous souhaitez stocker les fichiers



    public String saveFile(MultipartFile file) {
        try {
            // Générez un nom de fichier unique
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            // Construisez le chemin complet pour enregistrer le fichier
            Path filePath = Paths.get(UPLOAD_DIR, fileName);

            // Enregistrez le fichier sur le disque
            Files.copy(file.getInputStream(), filePath);

            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'enregistrement du fichier", e);
        }
    }


}
