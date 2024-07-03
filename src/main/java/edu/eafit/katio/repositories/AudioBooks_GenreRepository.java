package edu.eafit.katio.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.models.AudioBooks_Genre;

public interface AudioBooks_GenreRepository extends CrudRepository<AudioBooks_Genre, Long> {

     //Se hace los querys de la base de datos.

    @Query(
        nativeQuery = true,
        value = "DELETE FROM audiobooks_genre WHERE audiobook_id =:audiobookId"
    )
    Integer deleteByAudioBookId(@Param("audiobookId") Long audiobookId);
    
}
