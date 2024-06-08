package edu.eafit.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.dto.LoginResponse;
import edu.eafit.katio.dto.LoginUser;
import edu.eafit.katio.models.User;
import edu.eafit.katio.repository.UserRepository;
import edu.eafit.katio.services.AuthenticationService;
import edu.eafit.katio.services.JwtService;

@RestController
@RequestMapping("/katio/auth")
@CrossOrigin(origins = "*")
public class AuthController {


    private final JwtService _jwtService;
    private final AuthenticationService _authService;

    @Autowired
    private UserRepository userRepository;

    public AuthController(JwtService jwtService, AuthenticationService authService){
        _jwtService = jwtService;
        _authService = authService;
    }

    /**
     * 
     * @param registerUserDto
     * @return Usuario Registrado
     * Metodo postMapping de registro
     */
    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody User registerUserDto) {
        User registeredUser = _authService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }


    /**
     * 
     * @param loginUser
     * @return creado el usuario
     * Metodo postMapping para inicio de sesion
     */
    @PostMapping("/signin")
    public ResponseEntity<?> autehnticationUser(@RequestBody LoginUser loginUser){//@RequestBody AuthRequest authRequest){
        User authenticatedUser = _authService.authenticate(loginUser);
        String jwtToken = _jwtService.generateToken(authenticatedUser);
        LoginResponse loginresponse = new LoginResponse();
        loginresponse.setExpiresIn(_jwtService.getExpirationTime());
        loginresponse.setToken(jwtToken);
        return ResponseEntity.ok(loginresponse);
    }
}
