package edu.eafit.katio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Narrator")
public class Narrator {
    @Id
    private long Id;
    private String Name;
    private String LastName;
    private Languages Languages;
    private String Genre;


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
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public Languages getLanguages() {
        return Languages;
    }
    public void setLanguages(Languages languages) {
        Languages = languages;
    }
    public String getGenre() {
        return Genre;
    }
    public void setGenre(String genre) {
        Genre = genre;
    }


}
