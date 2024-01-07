package com.siproj.ensias.internship.service;

import org.springframework.stereotype.Service;

@Service
public interface AuthService {



    boolean authenticateEtudiant(String email);

}
