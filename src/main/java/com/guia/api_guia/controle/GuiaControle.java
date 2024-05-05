package com.guia.api_guia.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guia.api_guia.modelo.GuiaModelo;
import com.guia.api_guia.modelo.RespostaModelo;
import com.guia.api_guia.servico.GuiaServico;

@RestController
@CrossOrigin(origins = "*")

public class GuiaControle {

    @Autowired
    private GuiaServico servico;

    @GetMapping("/listarTodos")
    public Iterable<GuiaModelo> listarTodos(){
        return servico.listarTodos();
    }

    @GetMapping("/")
    public String rota(){
        return  "Api de produto funcionando";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody GuiaModelo guiaModelo){
        return servico.cadastrarAlterar(null, guiaModelo, "cadastrar");
    }
    
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody GuiaModelo guiaModelo){
        return servico.cadastrarAlterar(null, guiaModelo, "alterar");
    }
    @DeleteMapping("/deletarCadastro/{id}")
    public ResponseEntity<RespostaModelo> deletarCadastro(@PathVariable long id){
        return servico.deletarCadastro(id);

    }

    @PostMapping("/aprovarCadastro/{id}")
    public ResponseEntity<RespostaModelo> aprovarCadastro(@PathVariable long id) {
        return servico.aprovarCadastro(id);
    }

}
