package edu.eafit.katio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.eafit.katio.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    User saveAndFlush(User user);
    
    public Optional<User> getUserById(Long id);
      
    
    @Query(nativeQuery = true, value = "SELECT * FROM users where Email = :username")
    Optional<User> findByUserName(String username);

    Optional<User> findById();
}
