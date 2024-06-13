package edu.eafit.katio.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.eafit.katio.dtos.LoginUser;
import edu.eafit.katio.models.Usuarios;
import edu.eafit.katio.repository.UsuarioRepository;


@Service
public class AuthenticationService {
private final UsuarioRepository usuarioRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
        UsuarioRepository userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuarios signup(Usuarios input) {
        input.setPassword(passwordEncoder.encode(input.getPassword()));
        return usuarioRepository.saveAndFlush(input);
    }

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