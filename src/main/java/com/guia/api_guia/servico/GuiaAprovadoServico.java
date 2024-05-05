package com.guia.api_guia.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guia.api_guia.modelo.GuiaModeloAprovados;
import com.guia.api_guia.repositorio.GuiaRepositorioAprovado;

@Service
public class GuiaAprovadoServico {

    @Autowired
    private GuiaRepositorioAprovado guiaAprovadoRepo;

    // Método para salvar um cadastro na tabela de aprovados
    public GuiaModeloAprovados salvarAprovado(GuiaModeloAprovados guiaAprovado) {
        return guiaAprovadoRepo.save(guiaAprovado);
    }
    
}
