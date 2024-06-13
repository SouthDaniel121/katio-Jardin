
 package edu.eafit.katio.models;

import java.sql.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Id;
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

//Eventos que pasen
public enum LogEvent {
    LOGIN_SUCCESS,
    LOGIN_FAILURE,
    AUTHOR_PROFILE_VIEW
}
}

