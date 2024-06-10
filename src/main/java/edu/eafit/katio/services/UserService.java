package edu.eafit.katio.services;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import edu.eafit.katio.interfaces.BaseUserService;
import edu.eafit.katio.models.User;
import edu.eafit.katio.repository.UserRepository;

public class UserService implements BaseUserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public Iterable<User> getAllUsers() {
        var userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User addUser(User user) {
        var createdUser = new User();
        
        try{
            if(user.getPasshash().length() > 15)
            {
                user.setPasshash(blake3Formatter(user.getPasshash()));
                createdUser = userRepository.saveAndFlush(user);
                if(createdUser.getId() == 0)
                {
                    createdUser = null;
                }
            }
        }
        catch(Exception ex){
            System.out.println("[ERROR]: {}" + ex.getMessage());
        }
        
        return createdUser;
    }

    public Optional<User> findByEmail(String email)
    {
        return userRepository.findByUserName(email);
    }

    private String blake3Formatter(String value)  throws NoSuchAlgorithmException
    {
        final MessageDigest md = MessageDigest.getInstance("SHA3-512");
        byte[] hash = md.digest(value.getBytes(StandardCharsets.UTF_8));
        String sha3Hex = bytesToHex(hash);
        return sha3Hex;
    }

    private String bytesToHex(byte[] hash){
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while(hexString.length() < 64){
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    @Override
    public User updateUserByUsername(User user) {
        Optional<User> oldUser = userRepository.findByUserName(user.getEmail());
        if(oldUser.isPresent() && !oldUser.get().getEmail().isBlank())
        {
            oldUser.get()
                .setName(user.getName());
            oldUser.get().setLastname(user.getLastname());
            oldUser.get().setPhone(user.getPhone());
            oldUser.get().setIdentification(user.getIdentification());
            oldUser.get().setRoleId(user.getRoleId());

            return userRepository.saveAndFlush(oldUser.get());
        }
        else{
            return null;
        }
    }


    // @Override
    // public Usuarios updateUsuarioByUsername(String username, Usuarios updatedUsuario) { // Metodo que recibe el username del usuario que se desea actualizar
    //     Optional<Usuarios> optionalUsuario = usuarioRepository.findByUsername(username); //Llama al método findByUsername del repositorio usuarioRepository para buscar un usuario con el nombre de usuario proporcionado.
    //     if (optionalUsuario.isPresent()) { //Verifica si optionalUsuario contiene un valor (es decir, si el usuario fue encontrado).
    //         Usuarios existingUsuario = optionalUsuario.get(); //Si el usuario existe, obtiene el usuario actual de optionalUsuario.
            
    //         if (updatedUsuario.getNombre() != null) {
    //             existingUsuario.setNombre(updatedUsuario.getNombre()); //Actualiza cada campo del usuario existente con los valores del usuario actualizado (updatedUsuario).
    //         }
    //         if (updatedUsuario.getApellido() != null) {
    //             existingUsuario.setApellido(updatedUsuario.getApellido());
    //         }
    //         if (updatedUsuario.getEmail() != null) {
    //             existingUsuario.setEmail(updatedUsuario.getEmail());
    //         }
    //         if (updatedUsuario.getTelefono() != null) {
    //             existingUsuario.setTelefono(updatedUsuario.getTelefono());
    //         }
    //         if (updatedUsuario.getIdentificacion() != null) {
    //             existingUsuario.setIdentificacion(updatedUsuario.getIdentificacion());
    //         }
    
    //         return usuarioRepository.saveAndFlush(existingUsuario); //Guarda los cambios en la base de datos usando el método saveAndFlush del repositorio usuarioRepository
    //     } else {
    //         return null; // Usuario no encontrado
    //     }
    // }
}
