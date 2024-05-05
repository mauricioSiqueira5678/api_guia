package com.guia.api_guia.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.guia.api_guia.modelo.GuiaModeloAprovados;

public interface GuiaRepositorioAprovado extends CrudRepository <GuiaModeloAprovados, Long> {
    
}
