package edu.eafit.katio.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import edu.eafit.katio.dtos.AudioBooksDTO;
import edu.eafit.katio.interfaces.BaseAudioBookServices;
import edu.eafit.katio.models.AudioBooks;
import edu.eafit.katio.models.AudioBooks_Authors;
import edu.eafit.katio.models.AudioBooks_Genre;
import edu.eafit.katio.repositories.AudioBooksRepository;
import edu.eafit.katio.repositories.AudioBooks_AuthorsRepository;
import edu.eafit.katio.repositories.AudioBooks_GenreRepository;

public class AudioBookService implements BaseAudioBookServices{

    private final AudioBooksRepository _AudioBooksRepository;

    private final AudioBooks_AuthorsRepository _AudioBooks_AuthorsRepository;

    private final AudioBooks_GenreRepository _AudioBooks_GenreRepository;

    public AudioBookService(AudioBooksRepository audioBooksRepository){
        _AudioBooksRepository = audioBooksRepository;
        this._AudioBooks_AuthorsRepository = null;
        this._AudioBooks_GenreRepository = null;
    }

    public AudioBookService(AudioBooksRepository _AudioBooksRepository,
            AudioBooks_AuthorsRepository _AudioBooks_AuthorsRepository,
            AudioBooks_GenreRepository _AudioBooks_GenreRepository) {
        this._AudioBooksRepository = _AudioBooksRepository;
        this._AudioBooks_AuthorsRepository = _AudioBooks_AuthorsRepository;
        this._AudioBooks_GenreRepository = _AudioBooks_GenreRepository;
    }

    @Override
    public Iterable<AudioBooks> getAllAudioBooks() {
        var audioBookList = _AudioBooksRepository.findAll();
        return audioBookList;
    }

    @Override
    public Iterable<AudioBooks> findAudioBooksByEdition(String edition) {
        var audioBookList = _AudioBooksRepository.findAudioBooksByEdition(edition);
        return audioBookList;
    }
    
    public Iterable<AudioBooks> findAudioBooksByName(String name) {
        var audioBookList = _AudioBooksRepository.findAudioBooksByName(name);
        return audioBookList;
    }

    public Iterable<AudioBooks> findAudioBooksByDuration(Long duration) {
        var audioBookList = _AudioBooksRepository.findAudioBooksByLengthInSeconds(duration);
        return audioBookList;
    }
    
    public Iterable<AudioBooks> findAudioBooksByAuthor(String author){
        var audioBookList = _AudioBooksRepository.findAudioBooksByAuthor(author);
        return audioBookList;
    }

    public Iterable<AudioBooks> findAudioBooksByGenre(String genre){
        var audioBookList = _AudioBooksRepository.findAudioBooksByGenre(genre);
        return audioBookList;
    }

    public Iterable<AudioBooks> findAudioBooksByPublishedDate(Date published){
        var audioBookList = _AudioBooksRepository.findAudioBooksByPublishedDate(published);
        return audioBookList;
    }
    
    //Hacer la validacion para ver si ya existe el audiolibro
    public AudioBooks createAudioBooks(AudioBooksDTO audioBooks) {

        AudioBooks savedAudioBook = null;

        Boolean exist = false;

        Iterable<AudioBooks> savedAudioBooks = _AudioBooksRepository.findAudioBooksByName(audioBooks.getName());

        long count = StreamSupport.stream(savedAudioBooks.spliterator(), false).count();

        if(count > 0){
            savedAudioBook = _AudioBooksRepository.findAudioBooksByName(audioBooks.getName()).iterator().next();
        } 

        if(savedAudioBook != null){
            List<Long> authorsIds = StreamSupport
            .stream(_AudioBooks_AuthorsRepository.findByAudioBook(savedAudioBook.getId()).spliterator(), false)
            .collect(Collectors.toList());

            exist = authorsIds.stream().anyMatch(element -> audioBooks.getAuthors().contains(element));
        }

        if(exist){
            return null;
        } else {

            var audioBook = _AudioBooksRepository.save(new AudioBooks(audioBooks.getId(), audioBooks.getName(), audioBooks.getISBN10(), audioBooks.getISBN13(),
            audioBooks.getPublished(), audioBooks.getEdition(), audioBooks.getAbridged(), audioBooks.getLengthInSeconds(), audioBooks.getPath()));

            audioBooks.getAuthors().forEach((authorId) -> _AudioBooks_AuthorsRepository.save(new AudioBooks_Authors(audioBook.getId(), authorId)));
            audioBooks.getGenres().forEach((genreId) -> _AudioBooks_GenreRepository.save(new AudioBooks_Genre(audioBook.getId(), genreId)));
         
            return audioBook;

        }
        
    }

    public AudioBooks updateAudioBooks(AudioBooksDTO audioBooks) {

        AudioBooks savedAudioBook = null;

        Iterable<AudioBooks> savedAudioBooks = _AudioBooksRepository.findAudioBooksByName(audioBooks.getName());

        long count = StreamSupport.stream(savedAudioBooks.spliterator(), false).count();

        if(count > 0){
            savedAudioBook = _AudioBooksRepository.findAudioBooksByName(audioBooks.getName()).iterator().next();
        } 

        if(savedAudioBook != null && (savedAudioBook.getId() == audioBooks.getId())){
            var audioBook = _AudioBooksRepository.save(new AudioBooks(audioBooks.getId(), audioBooks.getName(), audioBooks.getISBN10(), audioBooks.getISBN13(),
            audioBooks.getPublished(), audioBooks.getEdition(), audioBooks.getAbridged(), audioBooks.getLengthInSeconds(), audioBooks.getPath()));

            _AudioBooks_AuthorsRepository.deleteByAudioBookId(audioBooks.getId());
            _AudioBooks_GenreRepository.deleteByAudioBookId(audioBooks.getId());

            audioBooks.getAuthors().forEach((authorId) -> _AudioBooks_AuthorsRepository.save(new AudioBooks_Authors(audioBook.getId(), authorId)));
            audioBooks.getGenres().forEach((genreId) -> _AudioBooks_GenreRepository.save(new AudioBooks_Genre(audioBook.getId(), genreId)));
         
            return audioBook;
        } else{
            return null;
        }
        
    }
}
