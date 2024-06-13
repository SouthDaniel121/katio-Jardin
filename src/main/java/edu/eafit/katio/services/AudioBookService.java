package edu.eafit.katio.services;

import java.sql.Date;

import edu.eafit.katio.interfaces.BaseAudioBookServices;
import edu.eafit.katio.models.AudioBooks;
import edu.eafit.katio.repository.AudioBooksRepository;

public class AudioBookService implements BaseAudioBookServices{

    private final AudioBooksRepository _AudioBooksRepository;

    public AudioBookService(AudioBooksRepository audioBooksRepository){
        _AudioBooksRepository = audioBooksRepository;
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
    public AudioBooks createAudioBooks(AudioBooks audioBooks) {
        var audioBook = _AudioBooksRepository.save(audioBooks);
        return audioBook;
    }
}
