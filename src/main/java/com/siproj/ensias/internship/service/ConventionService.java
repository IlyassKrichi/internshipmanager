package com.siproj.ensias.internship.service;

import org.springframework.web.multipart.MultipartFile;

public interface ConventionService {

    String saveFile(MultipartFile file);
}
