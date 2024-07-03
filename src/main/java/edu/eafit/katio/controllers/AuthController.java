package edu.eafit.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.dtos.LoginResponse;
import edu.eafit.katio.dtos.LoginUser;
import edu.eafit.katio.models.Usuarios;
import edu.eafit.katio.repositories.UsuarioRepository;
import edu.eafit.katio.services.AuthenticationService;
import edu.eafit.katio.services.JwtService;

@RestController
@RequestMapping("/katio/auth")
@CrossOrigin(origins = "*")
public class AuthController {



    //EL JWT TOKEN SIRVE PARA MEJORAR LA SEGURIDAD DEVOLVIENDO UNA ENCRIPTACION 
    //QUE ESA ENCRIPTACION LA HACE DE MANERA ALEATORIA,
    //CUAL CLAVE SE DENOMINA O SE LLAMA TOKEN, TU LLAVE DE ACCESO.
    //Requiere estar logueado*


    private final JwtService _jwtService;
    private final AuthenticationService _authService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public AuthController(JwtService jwtService, AuthenticationService authService){
        _jwtService = jwtService;
        _authService = authService;
    }




    //LOS DOS TIENEN QUE SER METODO SOLO DE ENVIO COMO ACTUALIZACION 
    //NO PODEMOS DEVOLVER INFORMACION EN PUBLICO TIPO COMUN COMPARAR LA CONTRASENA 





    /**
     * Este controlador es el principal de REGISTRO para poder paso en la 
     * pagina o perfil autorizado 
     * @param registerUserDto
     * @return → Usuario creado
     */
    @PostMapping("/signup")
    public ResponseEntity<Usuarios> register(@RequestBody Usuarios registerUserDto) {
        Usuarios registeredUser = _authService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }


    /**
     *  Este controlador es el principal de INICIO DE SESION para poder paso en la 
     * pagina o perfil autorizado 
     * 
     * @param loginUser
     *
     * @return → Login exitoso.
     */
    @PostMapping("/signin")
    public ResponseEntity<?> autehnticationUser(@RequestBody LoginUser loginUser){//@RequestBody AuthRequest authRequest){
        Usuarios authenticatedUser = _authService.authenticate(loginUser);
        String jwtToken = _jwtService.generateToken(authenticatedUser);
        LoginResponse loginresponse = new LoginResponse();
        loginresponse.setExpiresIn(_jwtService.getExpirationTime());
        loginresponse.setToken(jwtToken);
        return ResponseEntity.ok(loginresponse);
    }
}