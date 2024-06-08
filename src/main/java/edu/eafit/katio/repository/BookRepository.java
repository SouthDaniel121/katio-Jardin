package edu.eafit.katio.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.models.Books;

public interface BookRepository extends CrudRepository<Books, Long> {
    
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM Books WHERE Author_Id = ?1"
    )
    Iterable<Books> findByAuthorId(@Param("Author_Id") int authorId);

    @Query(nativeQuery = true,
        value = "SELECT " + //
                "au.id, bk.id as 'Id', bk.Name as 'Book_Name', bk.ISBN13, au.Name as 'Authors name', au.Lastname as 'Authors last name', CONCAT(au.Name, ' ', au.Lastname) as 'Author' " + //
                "FROM Authors au " +                 
                "JOIN Books bk ON bk.author_id = au.id " + //                
                "WHERE " + //
                "au.Lastname LIKE :lastname")
    Iterable<Books> findByAuthorLastName(@Param("lastname") String lastname);

    @Query(nativeQuery = true, 
        value = "SELECT * FROM BOOKS WHERE Name LIKE %:name%")
        Iterable<Books> findByName(@Param("name") String name);

        Books saveAndFlush(Books book);

        @Query(nativeQuery = true, 
        value = "SELECT * FROM BOOKS WHERE name LIKE %:edition%")
    Iterable<Books>findByEdition(@Param("edition") String edition);
       

    
    }
