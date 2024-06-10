package edu.eafit.katio.interfaces;

import java.util.Optional;

import edu.eafit.katio.models.Admin.Log;
import edu.eafit.katio.models.User;

public interface BaseAdminService {
    
    Iterable<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User addUser(User user);
    Iterable<User> findUsersByName(String name);
    Iterable<Log> getAllLogs();
    Optional<Log> findById(Long id);
}