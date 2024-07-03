package edu.eafit.katio.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;



//El dto es para poder hacer
//abstracción de datos eficientes al tiempo que promueven un acoplamiento flexible entre capas.
//Los getters and setters


@Entity
public class AudioBooksByAuthor {
    
    @Id
    @Column(name ="id_audiobook")
    private Long Id_AudioBook;

    @Column(name="audiobook_name")
    private String AudioBook_Name;

    @Column(name="isbn13")
    private String ISBN13;

    @Column(name="author_name")
    private String Author_Name;


    public Long getId_AudioBook() {
        return Id_AudioBook;
    }

    public void setId_AudioBook(Long id_AudioBook) {
        Id_AudioBook = id_AudioBook;
    }

    public String getAudioBook_Name() {
        return AudioBook_Name;
    }

    public void setAudioBook_Name(String audioBook_Name) {
        AudioBook_Name = audioBook_Name;
    }

    public String getISBN13() {
        return ISBN13;
    }

    public void setISBN13(String iSBN13) {
        ISBN13 = iSBN13;
    }

    public String getAuthor_Name() {
        return Author_Name;
    }

    public void setAuthor_Name(String author_Name) {
        Author_Name = author_Name;
    }
}
