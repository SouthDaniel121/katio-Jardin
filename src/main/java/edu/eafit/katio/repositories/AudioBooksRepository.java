package edu.eafit.katio.repositories;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.models.AudioBooks;

public interface AudioBooksRepository extends CrudRepository<AudioBooks, Long> {
    
    //Busqueda por ISBN10
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM audiobooks WHERE ISBN10 = ?1"
    )
    Optional<AudioBooks> findAudioBookByISBN10(@Param("ISBN10") String isbn10);


    //Busqueda por id de author
    @Query(
        nativeQuery = true,
        value = "SELECT ab.* FROM audiobooks_authors aba \n" +
        "INNER JOIN authors a ON a.ID= aba.author_id \n" +
        "INNER JOIN audiobooks ab ON ab.Id = aba.audiobook_id \n" +
        "WHERE aba.author_id = :authorId"
    )
    Iterable<AudioBooks> findAudioBooksByAuthor(@Param("authorId") String authorId);
    

    //Busqueda por nombre 
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM audiobooks WHERE name LIKE CONCAT('%',:name, '%')"
    )
    Iterable<AudioBooks> findAudioBooksByName(@Param("name") String name);


    //Busqueda por edition 
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM audiobooks WHERE edition LIKE CONCAT('%',:edition,'%')"
    )
    Iterable<AudioBooks> findAudioBooksByEdition(@Param("edition")String edition);


    //Busqueda por duracion
    @Query(
        nativeQuery = true,
        value = "SELECT * from audiobooks WHERE length_in_seconds LIKE %:lengthInSeconds% "
    )
    Iterable<AudioBooks> findAudioBooksByLengthInSeconds(@Param("lengthInSeconds") Long lengthInSeconds);

    //Creacion de guardado de audio libro 
    AudioBooks saveAndFlush(AudioBooks audioBooks);

    // Busqueda por genero 
    @Query(
        nativeQuery = true,
        value = "SELECT ab.* FROM audiobooks_genre abg \n" +
        "INNER JOIN genre g ON g.Id= abg.genre_id \n" +
        "INNER JOIN audiobooks ab ON ab.Id = abg.audiobook_id \n" +
        "WHERE abg.genre_id = :genreId"
    )
    Iterable<AudioBooks> findAudioBooksByGenre(@Param("genreId")String genre);


    //Busqueda por fecha de publicacion 
    @Query(
        nativeQuery = true,
        value = "SELECT * from audiobooks where published LIKE %:published% "
    )
    Iterable<AudioBooks> findAudioBooksByPublishedDate(@Param("published")Date published);
}
