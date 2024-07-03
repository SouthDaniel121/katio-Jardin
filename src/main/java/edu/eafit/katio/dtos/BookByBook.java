package edu.eafit.katio.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


//El dto es para poder hacer
//abstracción de datos eficientes al tiempo que promueven un acoplamiento flexible entre capas.
//Los getters and setters


@Entity
public class BookByBook {    
    @Id
    @Column(name ="id_book")
    private Long IdBook;

    @Column(name="book_name")
    private String BookName;

    @Column(name="isbn13")
    private String ISBN13;

    @Column(name="Author_Name")
    private String Author;
    
}

