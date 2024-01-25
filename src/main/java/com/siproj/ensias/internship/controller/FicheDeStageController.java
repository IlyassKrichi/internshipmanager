package com.siproj.ensias.internship.controller;

import com.siproj.ensias.internship.service.FicheDeStageServiceImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FicheDeStageController {

  private static String UPLOAD_DIR =
    "D:\\Personal files\\Documents\\ENSIAS GL\\Projet SI\\Projet SI GitHub\\internship\\src\\main\\java\\com\\siproj\\ensias\\internship\\pdf";

  FicheDeStageServiceImpl ficheDeStageService;

  @PostMapping("/api/fiches/submitFS")
  public void soumettreFiche(@RequestPart("file") MultipartFile file) {
    if (file.isEmpty()) {
      return;
    }

    try {
      byte[] bytes = file.getBytes();
      Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
      Files.write(path, bytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
