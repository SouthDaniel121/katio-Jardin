/*
 * 
 * package edu.eafit.katio.models;

import java.sql.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Admin {
    @Entity
public class Log {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LogEvent event;
    
    private Date timestamp;
    

}

public enum LogEvent {
    LOGIN_SUCCESS,
    LOGIN_FAILURE,
    BOOK_DOWNLOAD,
    AUDIOBOOK_PLAY,
    AUTHOR_PROFILE_VIEW
}
}

 */