package edu.eafit.katio.dtos;

import java.util.ArrayList;

import edu.eafit.katio.models.Genres;


//El dto es para poder hacer
//abstracción de datos eficientes al tiempo que promueven un acoplamiento flexible entre capas.
//Los getters and setters



public class GenreInsertdto {
    Long BookId;
    ArrayList<Genres> GenreList;

    public ArrayList<Genres> getGenreList() {
        return GenreList;
    }

    public void setGenreList(ArrayList<Genres> genreList) {
        GenreList = genreList;
    }

    public Long getBookId() {
        return BookId;
    }

    public void setBookId(Long bookId) {
        BookId = bookId;
    }
}