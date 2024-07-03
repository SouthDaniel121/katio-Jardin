package edu.eafit.katio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.eafit.katio.models.Usuarios;

public interface UsuarioRepository extends CrudRepository<Usuarios, Integer> {

    //Busqueda por nombre 
    @Query("SELECT u FROM Usuarios u WHERE u.Nombre = ?1")
    List<Usuarios> findByNombre(String Nombre);

    //Busqueda por identificacion 
    @Query("SELECT u FROM Usuarios u WHERE u.Identificacion= ?1")
    List<Usuarios> findByIdentificacion(String Identificacion);


    //Busqueda por Email  y contraseña en la list
    @Query("SELECT u FROM Usuarios u WHERE u.Email=?1")
    Usuarios findByEmailAndPasswordList (String Email);

    //Busqueda Por Email
    @Query("SELECT u FROM Usuarios u WHERE u.Email= ?1")
    List<Usuarios> findByEmail(String Email);

    //Busqueda por username
    @Query(nativeQuery = true, value = "SELECT * FROM Usuarios where Email = :username")
    Optional<Usuarios> findByUsername(String username);

    //Creacion y guardado 
    Usuarios saveAndFlush(Usuarios usuarios);





}