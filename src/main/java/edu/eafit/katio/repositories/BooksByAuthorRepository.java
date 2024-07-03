package edu.eafit.katio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.dtos.BooksByAuthor;

public interface BooksByAuthorRepository extends CrudRepository<BooksByAuthor, Long> {

    //Busqueda por id 
    @Query(nativeQuery = true,
    value = "SELECT " +
            "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, " +
            "au.LastName as Author_Name " +
            "FROM Authors au " +
            "JOIN Books bk ON bk.author_id = au.id " +
            "WHERE au.id = :idAuthor")
    List<BooksByAuthor> findByAuthorId(@Param("idAuthor") Integer idAuthor);

    //Busqueda por nombre
    @Query(nativeQuery = true,
    value = "SELECT " +
            "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, " +
            "au.LastName as Author_Name " +
            "FROM Authors au " +
            "JOIN Books bk ON bk.author_id = au.id " +
            "WHERE au.Name LIKE %:name%")
    List<BooksByAuthor> findByAuthorName(@Param("name") String name);


    //Busqueda por apellido 
    @Query(nativeQuery = true,
        value = "SELECT " +
                "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, " +
                "au.LastName as Author_Name " +
                "FROM Authors au " +
                "JOIN Books bk ON bk.author_id = au.id " +
                "WHERE au.LastName LIKE %:lastname%")
    List<BooksByAuthor> findByAuthorLastName(@Param("lastname") String lastName);


    //Busqueda por nombre completo
    @Query(nativeQuery = true,
        value = "SELECT " +
                "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, " +
                "au.LastName as Author_Name " +
                "FROM Authors au " +
                "JOIN Books bk ON bk.author_id = au.id " +
                "WHERE au.LastName LIKE %:lastname% OR au.Name LIKE %:name%")
    List<BooksByAuthor> findByAuthorFullName(@Param("lastname") String lastNameAuthor, @Param("name") String nameAuthor);


}

