package edu.eafit.katio.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



//El dto es para poder hacer
//abstracción de datos eficientes al tiempo que promueven un acoplamiento flexible entre capas.
//Los getters and setters


@Entity
@Table(name="Books_Genres")
public class GenreByBook {
    
    @Id
    @Column(name="Book_Id")
    Long Bookid;
    @Column(name="Genre_id")
    Long GenreId;
    public Long getBookid() {
        return Bookid;
    }
    public void setBookid(Long bookid) {
        Bookid = bookid;
    }
    public Long getGenreId() {
        return GenreId;
    }
    public void setGenreId(Long genreId) {
        GenreId = genreId;
    }
}