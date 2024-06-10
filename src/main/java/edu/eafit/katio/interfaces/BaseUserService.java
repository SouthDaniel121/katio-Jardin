package edu.eafit.katio.interfaces;

import edu.eafit.katio.models.User;

public interface BaseUserService {
    Iterable<User> getAllUsers();

    User addUser(User user);

    User updateUserByUsername(User user);
}
