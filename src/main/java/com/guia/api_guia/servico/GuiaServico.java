package com.guia.api_guia.servico;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.guia.api_guia.modelo.GuiaModelo;
import com.guia.api_guia.modelo.GuiaModeloAprovados;
import com.guia.api_guia.modelo.RespostaModelo;
import com.guia.api_guia.repositorio.GuiaRepositorio;
import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("unused")
@Service
public class GuiaServico {

    @Autowired
    private GuiaRepositorio guiaRepo;

    @Autowired
    private GuiaAprovadoServico guiaAprovadoServico;

    @Autowired
    private RespostaModelo resposta;

    //Metodo para listar todos os pendentes
    public Iterable <GuiaModelo> listarTodos(){
        return guiaRepo.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(MultipartFile imagem, GuiaModelo guiaModelo, String acao) {
    if (guiaModelo.getNome().isEmpty() || guiaModelo.getTel().isEmpty() || guiaModelo.getDescricao().isEmpty()) {
        resposta.setMensagem("Preencha os campos obrigatórios");
        return new ResponseEntity<RespostaModelo>(resposta, HttpStatus.BAD_REQUEST);
    } else {
        try {
            // Verifica se uma imagem foi enviada
            if (imagem != null && !imagem.isEmpty()) {
                // Se sim, converte a imagem para um array de bytes e salva no objeto guiaModelo
                guiaModelo.setImagem(imagem.getBytes());
            }
            // Salva ou atualiza o cadastro no banco de dados
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<GuiaModelo>(guiaRepo.save(guiaModelo), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<GuiaModelo>(guiaRepo.save(guiaModelo), HttpStatus.OK);
            }
        } catch (IOException e) {
            // Caso ocorra algum erro ao processar a imagem
            resposta.setMensagem("Erro ao processar a imagem: " + e.getMessage());
            return new ResponseEntity<RespostaModelo>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
    
    //Metodo para remover cadastro
    public ResponseEntity<RespostaModelo> deletarCadastro(long id){
        guiaRepo.deleteById(id);
        resposta.setMensagem("Cadastro removido com sucesso");
        return new ResponseEntity<RespostaModelo> (resposta, HttpStatus.OK);
    }

   
    // Método para aprovar cadastro pelo nome
    public ResponseEntity<RespostaModelo> aprovarCadastroPorNome(@RequestBody Map<String, String> payload) {
        String nome = payload.get("nome");
        List<GuiaModelo> guias = guiaRepo.findByNome(nome);
        if (!guias.isEmpty()) {
            GuiaModelo guiaPendente = guias.get(0); // assumindo que o primeiro resultado é o desejado

            // Criar uma instância de GuiaModeloAprovados com os mesmos dados
            GuiaModeloAprovados guiaAprovado = new GuiaModeloAprovados();
            guiaAprovado.setNome(guiaPendente.getNome());
                guiaAprovado.setTel(guiaPendente.getTel());
                guiaAprovado.setFace(guiaPendente.getFace());
                guiaAprovado.setInsta(guiaPendente.getInsta());
                guiaAprovado.setCategoria(guiaPendente.getCategoria());
                guiaAprovado.setDescricao(guiaPendente.getDescricao());
                guiaAprovado.setImagem(guiaPendente.getImagem());
            
            // Salvar na tabela de aprovados
            guiaAprovadoServico.salvarAprovado(guiaAprovado);

            // Remover o cadastro da tabela de pendentes
            guiaRepo.deleteById(guiaPendente.getId());

            resposta.setMensagem("Cadastro aprovado e movido para a lista de aprovados");
            return new ResponseEntity<>(resposta, HttpStatus.OK);
        } else {
            resposta.setMensagem("Cadastro não encontrado pelo nome");
            return new ResponseEntity<>(resposta, HttpStatus.NOT_FOUND);
        }
    }

 
}
