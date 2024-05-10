package com.guia.api_guia.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.guia.api_guia.modelo.LoginModelo;
import com.guia.api_guia.repositorio.LoginRepositorio;
import java.util.Optional;

@Service
public class LoginServiço {

    @Autowired
    private LoginRepositorio loginRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<LoginModelo> verificarLogin(String username, String password) {
        Optional<LoginModelo> usuario = loginRepositorio.findByUsername(username);
        if(usuario.isPresent() && passwordEncoder.matches(password, usuario.get().getPassword())) {
            return usuario;
        }
        return Optional.empty();
    }
}
