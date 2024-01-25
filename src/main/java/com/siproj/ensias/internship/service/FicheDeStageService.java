package com.siproj.ensias.internship.service;

import org.springframework.web.multipart.MultipartFile;

public interface FicheDeStageService {
  final String UPLOAD_DIR =
    "D:\\Personal files\\Documents\\ENSIAS GL\\Projet SI\\Projet SI GitHub\\internship\\src\\main\\java\\com\\siproj\\ensias\\internship\\pdf";

  String saveFile(MultipartFile file);
}
