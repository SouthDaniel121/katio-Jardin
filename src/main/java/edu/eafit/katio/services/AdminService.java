/*  
package edu.eafit.katio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eafit.katio.models.User;
import edu.eafit.katio.repository.UserRepository;

@Service
public class AdminService {
    
    @Autowired
    private UserRepository userRepository;
    
    
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
    
/* 
 * 
 *   public User getUser(Long id) {
        return userRepository.findAllById();
    }

        //En la base de datos agregar otro cambio activo o deshabilitado.
    public User editUser(Long id, User user) {
        User existingUser = getUser(id);
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }
 * 

  
    

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
    

 
}

*/