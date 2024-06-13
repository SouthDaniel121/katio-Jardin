package edu.eafit.katio.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.models.AudioBooks;

public interface AudioBooksRepository extends CrudRepository<AudioBooks, Long> {
    
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM audiobooks WHERE ISBN10 = ?1"
    )
    Optional<AudioBooks> findAudioBookByISBN10(@Param("ISBN10") String isbn10);

    
    @Query(
        nativeQuery = true,
        value = "SELECT ab.* FROM audiobooks ab \n" +
        "INNER JOIN authors a ON ab.Author_Id = a.ID \n" +
        "WHERE (:author = '' OR (a.Name LIKE CONCAT('%',:author, '%'))) \n"
    )
    Iterable<AudioBooks> findAudioBooksByAuthor(@Param("author") String author);
    

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM audiobooks WHERE name LIKE CONCAT('%',:name, '%')"
    )
    Iterable<AudioBooks> findAudioBooksByName(@Param("name") String name);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM audiobooks WHERE edition LIKE CONCAT('%',:edition,'%')"
    )
    Iterable<AudioBooks> findAudioBooksByEdition(@Param("edition")String edition); //hacer con SELECT FROM

    @Query(
        nativeQuery = true,
        value = "SELECT * from audiobooks WHERE length_in_seconds LIKE %:lengthInSeconds% "
    )
    Iterable<AudioBooks> findAudioBooksByLengthInSeconds(@Param("lengthInSeconds") Long lengthInSeconds);


    AudioBooks saveAndFlush(AudioBooks audioBooks);

    @Query(
        nativeQuery = true,
        value = "SELECT * from audiobooks WHERE genre LIKE %:genre% "
    )
    Iterable<AudioBooks> findAudioBooksByGenre(@Param("genre")String genre);

    @Query(
        nativeQuery = true,
        value = "SELECT * from audiobooks where published LIKE %:published% "
    )
    Iterable<AudioBooks> findAudioBooksByPublishedDate(@Param("published")Date published);
}
