package edu.eafit.katio.controllers;

import java.net.ConnectException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.repository.BookRepository;
import edu.eafit.katio.services.BookService;

@RestController
@RequestMapping("/katio/health")
public class HealthCheck {

    @Autowired
    private BookRepository _BookRepository;



    /**
     * 
     * @return  verifica el estado de salud del servicio de libros y la conexión a la base de datos
     */
    @GetMapping("/check")
    public ResponseEntity<String> healthCheck(){
        
        String result = "";
        try
        {
            new BookService(_BookRepository).getAllBooks();
            result = "Health Check: Passed \nDatabase Connection: Passed";            
        }
        catch(Exception ex)
        {
            if(ex.getCause() instanceof ConnectException)
            {
                result = "Health Check: Failed\n" +
                "Katio API: Online\n" +
                "Database Connection: Failed\n" +
                "[ERROR MESSAGE]: " + ex.getMessage();
            }
            else
            {
                result = "Health Check: Failed\n" +
                    "Katio API: Online\n" +
                    "[ERROR MESSAGE]: " + ex.getMessage();
            }
            
            
        }

        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}
