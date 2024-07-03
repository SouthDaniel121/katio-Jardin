package edu.eafit.katio.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="audiobooks")
public class AudioBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;
    private String ISBN10;
    private String ISBN13;
    private Date Published;
    private String Edition;
    private Boolean Abridged;
    @Column(name="LengthInSeconds")
    private Long LengthInSeconds;
    private String Path;

    public AudioBooks() {
    }
    
    public String getTimeNotation(){
       
        
        var horas = this.LengthInSeconds / 3600;
        return "Duracion: " + horas;
    }
    
    // Getters and Setters

    public AudioBooks(long id, String name, String iSBN10, String iSBN13, Date published, String edition,
            Boolean abridged, Long lengthInSeconds, String path) {
        Id = id;
        Name = name;
        ISBN10 = iSBN10;
        ISBN13 = iSBN13;
        Published = published;
        Edition = edition;
        Abridged = abridged;
        LengthInSeconds = lengthInSeconds;
        Path = path;
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

    /*public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }*/

    public Boolean getAbridged() {
        return Abridged;
    }

    public void setAbridged(Boolean abridged) {
        Abridged = abridged;
    }

    public Long getLengthInSeconds() {
        return LengthInSeconds;
    }

    public void setLengthInSeconds(Long lengthInSeconds) {
        LengthInSeconds = lengthInSeconds;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    //public Long getNarratorId() {
    //    return NarratorId;
    //}

    //public void setNarratorId(Long narratorId) {
    //    NarratorId = narratorId;
    //}

    /*public Long getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(Long authorId) {
        AuthorId = authorId;
    }*/
}
