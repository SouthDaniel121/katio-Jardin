package edu.eafit.katio.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


//El dto es para poder hacer
//abstracción de datos eficientes al tiempo que promueven un acoplamiento flexible entre capas.
//Los getters and setters


@Entity
public class BooksByAuthor {
    
    @Id
    @Column(name ="id_book")
    private Long IdBook;

    @Column(name="book_name")
    private String BookName;

    @Column(name="isbn13")
    private String ISBN13;

    @Column(name="Author_Name")
    private String Author;


    
    //Getters and Setters

    public Long getIdBook() {
        return IdBook;
    }

    public void setIdBook(Long idBook) {
        IdBook = idBook;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getISBN13() {
        return ISBN13;
    }

    public void setISBN13(String iSBN13) {
        ISBN13 = iSBN13;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }



}
