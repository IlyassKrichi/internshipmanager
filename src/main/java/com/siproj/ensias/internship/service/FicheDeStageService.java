package com.siproj.ensias.internship.service;

import org.springframework.web.multipart.MultipartFile;


public interface FicheDeStageService {

       final String UPLOAD_DIR = "/path/to/upload/directory"; // Remplacez par le chemin où vous souhaitez stocker les fichiers



        String saveFile(MultipartFile file);

    }