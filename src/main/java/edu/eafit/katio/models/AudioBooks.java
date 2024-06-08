package edu.eafit.katio.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="AudioBooks")
public class AudioBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;
    private String ISBN10;
    private String ISBN13;
    private Date Published;
    private String Edition;
    private String Genre;

    private boolean Abridged; // resumido o no.
    private long LengthInSeconds; // Duracion en segundos
    private String Path; // Donde esta ese libro en el disco.    
    private long AuthorId;    

    public String getTimeNotation(){
        var minutos = this.LengthInSeconds / 60;
        var horas = this.LengthInSeconds / 3600;
        return "Duración: " + horas;
    }





    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getISBN10() {
        return ISBN10;
    }
    public void setISBN10(String iSBN10) {
        ISBN10 = iSBN10;
    }
    public String getISBN13() {
        return ISBN13;
    }
    public void setISBN13(String iSBN13) {
        ISBN13 = iSBN13;
    }
    public Date getPublished() {
        return Published;
    }
    public void setPublished(Date published) {
        Published = published;
    }
    public String getEdition() {
        return Edition;
    }
    public void setEdition(String edition) {
        Edition = edition;
    }
    public String getGenre() {
        return Genre;
    }
    public void setGenre(String genre) {
        Genre = genre;
    }
    public boolean isAbridged() {
        return Abridged;
    }
    public void setAbridged(boolean abridged) {
        Abridged = abridged;
    }
    public long getLengthInSeconds() {
        return LengthInSeconds;
    }
    public void setLengthInSeconds(long lengthInSeconds) {
        LengthInSeconds = lengthInSeconds;
    }
    public String getPath() {
        return Path;
    }
    public void setPath(String path) {
        Path = path;
    }
    public long getAuthorId() {
        return AuthorId;
    }
    public void setAuthorId(long authorId) {
        AuthorId = authorId;
    }

    
}
