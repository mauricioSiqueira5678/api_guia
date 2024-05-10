package com.guia.api_guia.servico;

import java.util.List;

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

    //Metodo para listar todos os pendentes
    public Iterable<GuiaModeloAprovados> listarTodos(){
        return guiaAprovadoRepo.findAll();
    }

    public List<GuiaModeloAprovados> listarPorCategoria(String categoria){
        return guiaAprovadoRepo.findByCategoria(categoria);
    }
    
    public List<GuiaModeloAprovados> listarPorNome(String nome){
        return guiaAprovadoRepo.findByNomeContainingIgnoreCase(nome);
    }
}
