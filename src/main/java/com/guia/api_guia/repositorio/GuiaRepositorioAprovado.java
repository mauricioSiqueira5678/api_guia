package com.guia.api_guia.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.guia.api_guia.modelo.GuiaModeloAprovados;

public interface GuiaRepositorioAprovado extends CrudRepository<GuiaModeloAprovados, Long> {
    List<GuiaModeloAprovados> findByCategoria(String categoria);

    List<GuiaModeloAprovados> findByNomeContainingIgnoreCase(String nome);
}