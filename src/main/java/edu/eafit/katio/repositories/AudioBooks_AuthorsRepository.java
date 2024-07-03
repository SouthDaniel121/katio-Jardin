package edu.eafit.katio.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.models.AudioBooks_Authors;

public interface AudioBooks_AuthorsRepository extends CrudRepository<AudioBooks_Authors, Long> {


    //Se hace los querys de la base de datos.

   @Query(
        nativeQuery = true,
        value = "SELECT author_id from audiobooks_authors WHERE audiobook_id =:audiobookId"
    )
    Iterable<Long> findByAudioBook(@Param("audiobookId") Long audiobookId);

    @Query(
        nativeQuery = true,
        value = "DELETE FROM audiobooks_authors WHERE audiobook_id =:audiobookId"
    )
    Integer deleteByAudioBookId(@Param("audiobookId") Long audiobookId); 
}
