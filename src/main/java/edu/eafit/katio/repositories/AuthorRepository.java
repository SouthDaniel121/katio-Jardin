package edu.eafit.katio.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.models.Authors;

public interface AuthorRepository extends CrudRepository<Authors, Long> {


    //Busqueda por id
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM Authors WHERE Id like %:id%")
    List<Authors> findById(@Param("id") Integer id);


    //Busqueda por nombre 
    @Query(
        nativeQuery = true, 
        value = "SELECT * FROM Authors WHERE Name LIKE %:name%")
    List<Authors> findByName(@Param("name") String name);


    //Busqueda por pais
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM Authors WHERE Country LIKE %:country%")
    List<Authors> findByCountry(String country);
    
    //Busqueda por nombre 
    @Query(
        nativeQuery = true, 
        value = "SELECT * FROM Authors a WHERE a.Name = :name")
    Optional<Authors> findByNameOpt(@Param("name") String name);

        //Busqueda por fecha inicial y final. RANGO
        @Query(
        nativeQuery = true,
        value = "SELECT * FROM Authors WHERE Birthdate BETWEEN :startDate AND :endDate"
    )
    List<Authors> findByPublishedDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    //Creacion y guardado de author.
    Authors saveAndFlush(Authors authors);
}