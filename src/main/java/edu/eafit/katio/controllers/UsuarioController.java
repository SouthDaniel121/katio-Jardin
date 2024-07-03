package edu.eafit.katio.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.models.Usuarios;
import edu.eafit.katio.repositories.UsuarioRepository;
import edu.eafit.katio.services.AuthenticationService;
import edu.eafit.katio.services.JwtService;
import edu.eafit.katio.services.UsuarioService;

@RestController
@RequestMapping("katio/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    private final JwtService _jwtService;
    private final AuthenticationService _authService;


    @Autowired 
    //Esto es la conexion de JWT TOKEN 
    private UsuarioRepository usuarioRepository;
    public UsuarioController(JwtService jwtService, AuthenticationService authService){
        _jwtService = jwtService;
        _authService = authService;
    }



    /**
     * Metodo GET
     * Este controlador nos sirve para poder traer todo los usuarios creados
     * @return todo los usuarios 
     */
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Usuarios>> getAllUsuarios() {

        var usuarios = new UsuarioService(usuarioRepository).getAllUsuarios();
        return new ResponseEntity<Iterable<Usuarios>>(usuarios, HttpStatus.OK);
    }


    /**
     * Metodo Get
     * Este controlador nos sirve para poder traer por un numero especifico un usuario.
     * @param id
     * @return id == id ingresado. (Por el postman)
     */
    @GetMapping("/id")
    public ResponseEntity<Optional<Usuarios>> getUsuarioById(@RequestParam("Id") Integer id) {

        var usuarioById = new UsuarioService(usuarioRepository).getUsuarioById(id);
        return new ResponseEntity<Optional<Usuarios>>(usuarioById, HttpStatus.OK);

    }

    /**
     * Metodo Put crear 
     * Esto se puede hacer desde el authController. (AQUI SERIA COMO ADMIN)
     * @param usuarios
     * @return Usuario creado 
     */
    @PutMapping("/add")
    public ResponseEntity<Usuarios> addUsuarios(@RequestBody Usuarios usuarios) {

        var usuarioCreado = new UsuarioService(usuarioRepository).addUsuarios(usuarios);
        return usuarioCreado.getId() == 0 ? new ResponseEntity<Usuarios>(usuarioCreado, HttpStatus.BAD_REQUEST)
                : new ResponseEntity<Usuarios>(usuarioCreado, HttpStatus.OK);

    }

    /**
     * Metodo Post Actualizar
     * Este controlador nos sirve para poder actualizar o cambiar informacion del usuario.
     * @param usuarios
     * @return Usuario Actualizado
     */
    @PostMapping("/update")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuarios usuarios){
       var updatedUser = new UsuarioService(usuarioRepository).updateUsuarioByUsername(usuarios);  
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

     /**
     * Metodo Get
     * Nos sirve para traer un usuario por nombre 
     * @param nombre
     * @return nombre == Nombre igual. (Por el postman)
     */
    @GetMapping("/nombre")
    public ResponseEntity<Iterable<Usuarios>> getByNombre(@RequestParam("Nombre") String nombre) {
        var usuarioByNombre = new UsuarioService(usuarioRepository).getUsuarioByNombre(nombre);
        return new ResponseEntity<Iterable<Usuarios>>(usuarioByNombre, HttpStatus.OK);
    }


    /**
     * Metodo GET
     * Este controlador nos permite traer por identificacion.
     * @param identificacion
     * @return identificacion == Identificacion ingresado. (Por el postman)
     */
    @GetMapping("/identificacion")
    public ResponseEntity<Iterable<Usuarios>> getByIdentificacion(
            @RequestParam("Identificacion") String identificacion) {
        var usurioByIdentificacion = new UsuarioService(usuarioRepository).getUsuarioByIdentificacion(identificacion);
        return new ResponseEntity<Iterable<Usuarios>>(usurioByIdentificacion, HttpStatus.OK);
    }


}