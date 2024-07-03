package edu.eafit.katio.dtos;

import java.util.Date;
import java.util.List;


//El dto es para poder hacer
//abstracción de datos eficientes al tiempo que promueven un acoplamiento flexible entre capas.
//Los getters and setters



public class AudioBooksDTO {
    private long Id;
    private String Name;
    private String ISBN10;
    private String ISBN13;
    private Date Published;
    private String Edition;
    private Boolean Abridged;
    private Long lengthInSeconds;
    private String Path;
    private List<Long> authors;
    private List<Long> genres;

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

    public Boolean getAbridged() {
        return Abridged;
    }

    public void setAbridged(Boolean abridged) {
        Abridged = abridged;
    }

    public Long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(Long lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public List<Long> getAuthors() {
        return authors;
    }
    
    public void setAuthors(List<Long> authors) {
        this.authors = authors;
    }

    public List<Long> getGenres() {
        return genres;
    }

    public void setGenres(List<Long> genres) {
        this.genres = genres;
    }
    
}


