package edu.eafit.katio.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.models.Narrator;
import edu.eafit.katio.services.NarratorService;

@RestController
@RequestMapping("/katio/Narrator")
@CrossOrigin(origins = "*")
public class NarratorController{


//Post → http://localhost:8080/katio/Narrator/add

@Autowired 
private NarratorService narratorService; 



/**
 * 
 * @param narrator
 * @return Author Creado
 */
@PostMapping("/add")
public ResponseEntity<Narrator> addNarrator(@RequestBody Narrator narrator) {
    Narrator createdNarrator = narratorService.addNarrator(narrator);

    if (createdNarrator == null) {
        return ResponseEntity.badRequest().build(); 
    }

    return ResponseEntity.ok(createdNarrator);
} 


    /**
     * 
     * @return Todos los narradores
     */
     @GetMapping("/getall")
    public ResponseEntity<Iterable<Narrator>> getAllnarrator(){
        Iterable<Narrator> narrators = new NarratorService(narratorService).getAllNarrator();
        return ResponseEntity.ok(narrators);
    }

  
   
    /**
     * 
     * @param id
     * @return Author por id
     */
    @GetMapping ("/NarratorById/{id}")
    public Optional<Narrator> getNarratorById(@PathVariable("id") Integer id){
        return new NarratorService(narratorService).geNarratorById(id);
   }
    

}
 