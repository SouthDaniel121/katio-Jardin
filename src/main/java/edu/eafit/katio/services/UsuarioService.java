package edu.eafit.katio.services;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import edu.eafit.katio.interfaces.BaseUsuarioService;
import edu.eafit.katio.models.Usuarios;
import edu.eafit.katio.repositories.UsuarioRepository;

public class UsuarioService implements BaseUsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Creacion de la lista 
    @Override
    public Iterable<Usuarios> getAllUsuarios() {
        var listaUsuarios = usuarioRepository.findAll();
        return listaUsuarios;
    }


    //Crear un agregar usuario 
    @Override
    public Usuarios addUsuarios(Usuarios usuarios) {
        var usuarioCreado = new Usuarios();

        try {
            if (usuarios.getPassword().length() > 5) {

                 usuarios.setPassword(blake3Formatter(usuarios.getPassword()));
                 usuarioCreado = usuarioRepository.saveAndFlush(usuarios);
            } else {

            }

        } catch (Exception ex) {
        }

        return usuarioCreado;
    }


     private String blake3Formatter(String value) throws NoSuchAlgorithmException
     {
     final MessageDigest md = MessageDigest.getInstance("SHA3-512");

     byte[] hash = md.digest(value.getBytes(StandardCharsets.UTF_8));
     String sha3Hex = bytesToHex(hash);
     return sha3Hex;
     }




     private String bytesToHex(byte[] hash) {
     BigInteger number = new BigInteger(1, hash);
     StringBuilder hexString = new StringBuilder(number.toString(16));
     while (hexString.length() < 64) {
     hexString.insert(0, '0');
     }
     return hexString.toString();
      }




      //Crear traer por id 
    @Override
    public Optional<Usuarios> getUsuarioById(Integer id) {
        return usuarioRepository.findById(id);

    }


    //Crear traer por Nombre 
    @Override
    public Iterable<Usuarios> getUsuarioByNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }


    //Crear traer por identificacion 
    @Override
    public Iterable<Usuarios> getUsuarioByIdentificacion(String identificacion) {
        return usuarioRepository.findByIdentificacion(identificacion);
    }


    //Crear validar usuario por Email y Contraseña
    @Override
    public Usuarios getUsuarioByEmailAndPassword(String email, String password) throws NoSuchAlgorithmException {
        Usuarios usuarioLogin = usuarioRepository.findByEmailAndPasswordList(email);

        if (usuarioLogin != null) {


            String validPassword = blake3Formatter(password);
            if (usuarioLogin.getPassword().equals(validPassword)){

            };                
            return usuarioLogin;


        } else {
            return null;
        }
    }

    //Crea traer usuario por EMail 
    @Override
    public Iterable<Usuarios> getUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }


    //Crear actualizacion o cambios del usuario 
    @Override
    public Usuarios updateUsuarioByUsername (Usuarios usuarios){
        Optional<Usuarios> optionalUsuario = usuarioRepository.findByUsername(usuarios.getUsername());

        if(optionalUsuario.isPresent() && !optionalUsuario.get().getEmail().isBlank())
        {
            optionalUsuario.get().setNombre(usuarios.getNombre());
                optionalUsuario.get().setApellido(usuarios.getApellido());
                optionalUsuario.get().setTelefono(usuarios.getTelefono());
                optionalUsuario.get().setIdentificacion(usuarios.getIdentificacion());
                //optionalUsuario.get().setRoleId(usuarios.getRoleId());

            return usuarioRepository.saveAndFlush(optionalUsuario.get());
        }
        else{
            return null;
        }
    }

  


  }