package edu.eafit.katio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.models.Narrators;

public interface NarratorRepository extends CrudRepository<Narrators, Long> {
    
    //Busqueda por id 
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM NARRATORS WHERE Id like %:id%") 
    List<Narrators> findById(@Param("id") Integer id);

    //Busqueda por nombre  LIST
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM NARRATORS WHERE Name like %:name%") 
    List<Narrators> findByName(@Param("name") String name);

    //Busqueda por nombre  OPTIONAL
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM NARRATORS WHERE Name like %:name%") 
    Optional<Narrators> findByNameOpt(@Param("name") String name);

    //Busqueda por apellido 
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM NARRATORS WHERE Lastname like %:lastname%") 
    List<Narrators> findByLastName(@Param("lastname") String lastName);
    
    //Busqueda por genero 
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM NARRATORS WHERE Genre like %:genre%") 
    List<Narrators> findByGenre(@Param("genre") String genre);

    //Creacion y guardado
    Narrators saveAndFlush(Narrators narrators);
}
