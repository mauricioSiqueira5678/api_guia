package com.guia.api_guia.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/listarAprovadosPorCategoria")
    public ResponseEntity<List<GuiaModeloAprovados>> listarPorCategoria(@RequestParam String categoria) {
        List<GuiaModeloAprovados> listaFiltrada = servico.listarPorCategoria(categoria);
        return ResponseEntity.ok(listaFiltrada);
    }

    @GetMapping("/pesquisarPorNome")
        public ResponseEntity<List<GuiaModeloAprovados>> pesquisarPorNome(@RequestParam String nome) {
        List<GuiaModeloAprovados> resultados = servico.listarPorNome(nome);
        return ResponseEntity.ok(resultados);
}
}
