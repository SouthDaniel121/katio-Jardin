package edu.eafit.katio.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.eafit.katio.dtos.LoginUser;
import edu.eafit.katio.models.Usuarios;
import edu.eafit.katio.repositories.UsuarioRepository;

@Service
public class AuthenticationService {
private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
        UsuarioRepository usuarioRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //lOGIN Servicio 
    public Usuarios signup(Usuarios input) {
        input.setPassword(passwordEncoder.encode(input.getPassword()));
        return usuarioRepository.saveAndFlush(input);
    }

    //Creacion SERVICIO Autentificador 
    public Usuarios authenticate(LoginUser input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return usuarioRepository.findByUsername(input.getEmail())
                .orElseThrow();
    }
}
