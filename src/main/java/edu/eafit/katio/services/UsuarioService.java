package edu.eafit.katio.services;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import edu.eafit.katio.interfaces.BaseUserService;
import edu.eafit.katio.models.Usuarios;
import edu.eafit.katio.repository.UsuarioRepository;

public class UsuarioService implements BaseUserService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Iterable<Usuarios> getAllUsuarios() {
        var listaUsuarios = usuarioRepository.findAll();
        return listaUsuarios;
    }

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
     




    @Override
    public Optional<Usuarios> getUsuarioById(Integer id) {
        return usuarioRepository.findById(id);

    }

    @Override
    public Iterable<Usuarios> getUsuarioByNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    @Override
    public Iterable<Usuarios> getUsuarioByIdentificacion(String identificacion) {
        return usuarioRepository.findByIdentificacion(identificacion);
    }

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

    @Override
    public Iterable<Usuarios> getUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }



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
/*
    @Override
    public Usuarios updateUsuarioByUsername(String username, Usuarios updatedUsuario) { // Metodo que recibe el username del usuario que se desea actualizar
        Optional<Usuarios> optionalUsuario = usuarioRepository.findByUsername(username); //Llama al método findByUsername del repositorio usuarioRepository para buscar un usuario con el nombre de usuario proporcionado.
        if (optionalUsuario.isPresent()) { //Verifica si optionalUsuario contiene un valor (es decir, si el usuario fue encontrado).
            Usuarios existingUsuario = optionalUsuario.get(); //Si el usuario existe, obtiene el usuario actual de optionalUsuario.
            
            if (updatedUsuario.getNombre() != null) {
                existingUsuario.setNombre(updatedUsuario.getNombre()); //Actualiza cada campo del usuario existente con los valores del usuario actualizado (updatedUsuario).
            }
            if (updatedUsuario.getApellido() != null) {
                existingUsuario.setApellido(updatedUsuario.getApellido());
            }
            if (updatedUsuario.getEmail() != null) {
                existingUsuario.setEmail(updatedUsuario.getEmail());
            }
            if (updatedUsuario.getTelefono() != null) {
                existingUsuario.setTelefono(updatedUsuario.getTelefono());
            }
            if (updatedUsuario.getIdentificacion() != null) {
                existingUsuario.setIdentificacion(updatedUsuario.getIdentificacion());
            }
    
            return usuarioRepository.saveAndFlush(existingUsuario); //Guarda los cambios en la base de datos usando el método saveAndFlush del repositorio usuarioRepository
        } else {
            return null; // Usuario no encontrado
        }
    }*/

    

    
  }
   
