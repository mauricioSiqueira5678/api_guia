package com.guia.api_guia.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guia.api_guia.modelo.GuiaModeloAprovados;
import com.guia.api_guia.servico.GuiaAprovadoServico;

@RestController
@CrossOrigin(origins = "*")
public class GuiaControleAprovado {

    @Autowired
    private GuiaAprovadoServico servico;

    @GetMapping("/listarTodosAprovados")
    public Iterable<GuiaModeloAprovados> listarTodos() {
        return servico.listarTodos();
    }
    
}
