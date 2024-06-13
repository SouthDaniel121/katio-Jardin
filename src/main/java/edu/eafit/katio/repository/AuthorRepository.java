package edu.eafit.katio.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.eafit.katio.models.Authors;

public interface AuthorRepository extends CrudRepository<Authors, Long> {

    @Query("SELECT a FROM Authors a WHERE a.Name = :name")
    Iterable<Authors> findByName(String name);

    @Query("SELECT a FROM Authors a WHERE a.Country = :country")
    Iterable<Authors> findByCountry(String country);

 

    
   
}