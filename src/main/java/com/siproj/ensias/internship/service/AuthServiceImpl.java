package com.siproj.ensias.internship.service;

import com.siproj.ensias.internship.model.Etudiant;
import com.siproj.ensias.internship.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{
    private final EtudiantRepository etudiantRepository;

    @Autowired
    public AuthServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }


    public boolean authenticateEtudiant(String email, String password) {
        try {
            Optional<Etudiant> etudiantOptional = etudiantRepository.findByEmail(email);

            if (etudiantOptional.isPresent()) {
                Etudiant etudiant = etudiantOptional.get();
                return password.equals(etudiant.getPassword());
            }

            return false;
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            e.printStackTrace();
            return false;
        }
    }


}

