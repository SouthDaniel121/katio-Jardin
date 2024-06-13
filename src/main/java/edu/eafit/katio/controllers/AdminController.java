
package edu.eafit.katio.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.models.User;
import edu.eafit.katio.services.AdminService;

@RestController
@RequestMapping("/katio/admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    

    /**
     * 
     * @return lista de usuarios.
     */
    @GetMapping("/users")
    public List<User> getUsers() {
        return adminService.getUsers();
    }
    


    /**
     * 
     * @param id
     * @return user base el id.
     */
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return adminService.getUser(id);
    }
    
    /**
     * 
     * @param id
     * @param user
     * @return actualizar datos del usuario por id.
     */
    @PutMapping("/users/{id}")
    public User editUser(@PathVariable Long id, @RequestBody User user) {
        return adminService.editUser(id, user);
    }
    
    
    /**
     * 
     * @param id
     *  Deshabilitar usuario por id del user.
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        adminService.deleteUser(id);
    }
    

   
    
}