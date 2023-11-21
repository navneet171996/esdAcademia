package com.iiitb.esdMiniProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiitb.esdMiniProject.entities.Admin;

public interface AdminRepository  extends JpaRepository<Admin, Integer>{

    Optional<Admin> findByUsername(String username);
    
}
