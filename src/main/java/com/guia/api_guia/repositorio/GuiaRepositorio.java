package com.guia.api_guia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guia.api_guia.modelo.GuiaModelo;

@Repository


public interface GuiaRepositorio extends JpaRepository<GuiaModelo, Long> {
    List<GuiaModelo> findByNome(String nome);

    List<GuiaModelo> findByNomeContainingIgnoreCase(String nome);
}