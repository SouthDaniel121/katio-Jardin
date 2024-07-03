package edu.eafit.katio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="audiobooks_genre")
public class AudioBooks_Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private long audiobook_id;
    private long genre_id;

    //Getters and Setters 

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setAudiobook_id(long audiobook_id) {
        this.audiobook_id = audiobook_id;
    }

    public AudioBooks_Genre(long audiobook_id, long genre_id) {
        this.audiobook_id = audiobook_id;
        this.genre_id = genre_id;
    }

    public AudioBooks_Genre() {
    }

    public long getAudiobook_id() {
        return audiobook_id;
    }

    public void setAudiobook_id(Integer audiobook_id) {
        this.audiobook_id = audiobook_id;
    }

    public long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(long genre_id) {
        this.genre_id = genre_id;
    }
    
}
