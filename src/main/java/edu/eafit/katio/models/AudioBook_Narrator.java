package edu.eafit.katio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class AudioBook_Narrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private long audiobook_id;
    private Integer narrator_id;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public long getAudiobook_id() {
        return audiobook_id;
    }

    public void setAudiobook_id(long audiobook_id) {
        this.audiobook_id = audiobook_id;
    }

    public Integer getNarrator_id() {
        return narrator_id;
    }
    
    public void setNarrator_id(Integer narrator_id) {
        this.narrator_id = narrator_id;
    }
    
}
