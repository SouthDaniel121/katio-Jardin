/*package edu.eafit.katio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eafit.katio.models.Admin.Log;
import edu.eafit.katio.models.User;

@Repository
public interface AdminRepository extends JpaRepository<User, Long> {
    
    User saveAndFlush(User user);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User getUserByEmail(@Param("email") String email);


    @Query("SELECT l FROM Log l")
    Iterable<Log> getLogs();

    @Query("SELECT u FROM User u WHERE u.active = false")
    Iterable<User> getInactiveUsers();

    @Query("SELECT u FROM User u WHERE u.loginAttempts >= 10")
    Iterable<User> getUsersWithFailedLogins();

    void deleteUser(Long id);

    void incrementLoginAttempts(User user);

    void resetLoginAttempts(User user);

    


} */