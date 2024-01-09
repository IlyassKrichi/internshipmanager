package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.model.Etudiant;
import com.siproj.ensias.internship.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthServiceImpl implements AuthService{
    private final EtudiantRepository etudiantRepository;

    @Autowired
    public AuthServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public boolean authenticateEtudiant(String email) {
        Etudiant etudiant = etudiantRepository.findByEmail(email);

        return etudiant != null;
    }
}
