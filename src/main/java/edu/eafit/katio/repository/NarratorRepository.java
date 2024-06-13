package edu.eafit.katio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.models.Narrators;

public interface NarratorRepository extends CrudRepository<Narrators, Long> {
    
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM NARRATORS WHERE Id like %:id%") 
    List<Narrators> findById(@Param("id") Integer id);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM NARRATORS WHERE Name like %:name%") 
    List<Narrators> findByName(@Param("name") String name);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM NARRATORS WHERE Name like %:name%") 
    Optional<Narrators> findByNameOpt(@Param("name") String name);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM NARRATORS WHERE Lastname like %:lastname%") 
    List<Narrators> findByLastName(@Param("lastname") String lastName);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM NARRATORS WHERE Genre like %:genre%") 
    List<Narrators> findByGenre(@Param("genre") String genre);

    Narrators saveAndFlush(Narrators narrators);
}
