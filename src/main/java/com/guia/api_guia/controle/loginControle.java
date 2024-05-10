package com.guia.api_guia.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.guia.api_guia.modelo.LoginModelo;
import com.guia.api_guia.servico.LoginServiço;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class loginControle {

    @Autowired
    private LoginServiço loginServico;

    @PostMapping
    public void verificarLogin(@RequestBody LoginModelo login, HttpServletResponse response) throws IOException {
        Optional<LoginModelo> usuarioExistente = loginServico.verificarLogin(login.getUsername(), login.getPassword());
        if (usuarioExistente.isPresent()) {
            response.sendRedirect("/pendente.html");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Usuário não encontrado ou senha incorreta!");
        }
    }
}

