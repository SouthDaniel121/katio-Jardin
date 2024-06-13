package edu.eafit.katio.interfaces;

import edu.eafit.katio.models.AudioBooks;

public interface BaseAudioBookServices {
    Iterable<AudioBooks> getAllAudioBooks();
    Iterable<AudioBooks> findAudioBooksByEdition(String edition);
    


     //Optional<AudioBooks> findAudioBookByISBN10(String isbn10); // Se hace el metodo en el reposotorio
    //Iterable<AudioBooks> findAudioBooksByAuthor(String author); // Se hace el metodo en el reposotorio
    //Iterable<AudioBooks> findAudioBooksByName(String name); // Se hace el metodo en el reposotorio
}
