package edu.eafit.katio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eafit.katio.models.Narrator;

@Repository
public interface NarratorRepository extends CrudRepository<Narrator, Long> {

    @Query(nativeQuery = true,
    value = "SELECT * FROM NARRATOR")
    Narrator getAllNarrator();


    @Query(nativeQuery = true, 
        value = "SELECT * FROM BOOKS WHERE id = :id")
    Narrator findById(@Param("id") long id);

    @Query(nativeQuery = true, 
        value = "SELECT * FROM BOOKS WHERE name LIKE %:name%")
    Iterable<Narrator> findByName(@Param("name") String name);

    public static Narrator saveAndFlush(Narrator narrator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
    }
    
 static List<Narrator>getAllNarrator(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'getnarrator'");
    }


} 
