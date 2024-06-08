package edu.eafit.katio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.dto.BookByAuthor;

public interface BooksByAuthorRepository extends JpaRepository<BookByAuthor, Long> {
    
    @Query(nativeQuery = true,
        value =
            "SELECT " +
                "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, "+
                "au.LastName as Author_Name " +
            "FROM Authors au " +
            "JOIN Books bk ON bk.author_id = au.id " +
            "WHERE " +
                "au.Lastname LIKE %:lastname%")
    Iterable<BookByAuthor> findByAuthorLastName(@Param("lastname") String lastname);

    @Query(nativeQuery = true,
        value =
            "SELECT " +
                "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, "+
                "au.LastName as Author_Name " +
            "FROM Authors au " +
            "JOIN Books bk ON bk.author_id = au.id " +
            "WHERE " +
                "au.Name LIKE %:name%")
    Iterable<BookByAuthor> findByAuthorName(@Param("name") String name);

    @Query(nativeQuery = true,
        value =
            "SELECT " +
                "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, "+
                "au.LastName as Author_Name " +
            "FROM Authors au " +
            "JOIN Books bk ON bk.author_id = au.id " +
            "WHERE " +
                "au.Lastname LIKE %:lastname% OR au.Name LIKE %:name%")
    Iterable<BookByAuthor> findByAuthorFullName(@Param("lastname") String lastname, @Param("name") String name);
}
