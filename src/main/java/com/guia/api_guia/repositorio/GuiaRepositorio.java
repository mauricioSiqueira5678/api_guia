package com.guia.api_guia.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guia.api_guia.modelo.GuiaModelo;

@Repository
public interface GuiaRepositorio extends CrudRepository<GuiaModelo, Long>{
    
}
