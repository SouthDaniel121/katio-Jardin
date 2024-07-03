package edu.eafit.katio.services;

import edu.eafit.katio.interfaces.BaseAudioBooks_AuthorsService;
import edu.eafit.katio.models.AudioBooks_Authors;
import edu.eafit.katio.repositories.AudioBooks_AuthorsRepository;

public class AudioBooks_AuthorsService implements BaseAudioBooks_AuthorsService {

    private final AudioBooks_AuthorsRepository _AudioBooks_AuthorsRepository;

    //Servicio de busquedas y guardados

          //Crear el servicio entre repositorios base el autor y libro
          public AudioBooks_Authors createAudioBooks_Authors(AudioBooks_Authors audioBooksAuthors) {
            var saveAudioBooksAuthors = _AudioBooks_AuthorsRepository.save(audioBooksAuthors);
    
            return saveAudioBooksAuthors;
        }
    
        //Crear el servicio entre repositorios base el id del libro y author 
        public Iterable<Long> findByAudioBook(Long audiobookId){
            var authorsIds = _AudioBooks_AuthorsRepository.findByAudioBook(audiobookId);
    
            return authorsIds;
        }

    public AudioBooks_AuthorsService(AudioBooks_AuthorsRepository audioBooks_AuthorsRepository){
        _AudioBooks_AuthorsRepository = audioBooks_AuthorsRepository;
    }
    
    //Crear el servicio entre repositorios
    public Integer deleteByAudioBookId(Long audiobookId){
        return _AudioBooks_AuthorsRepository.deleteByAudioBookId(audiobookId);
    }


}
