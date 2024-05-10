package com.guia.api_guia.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guia.api_guia.modelo.LoginModelo;

public interface LoginRepositorio extends JpaRepository<LoginModelo, Long> {
    Optional<LoginModelo> findByUsername(String username);
} 
    

