package edu.eafit.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.models.Narrators;
import edu.eafit.katio.repository.NarratorRepository;
import edu.eafit.katio.services.NarratorService;

@RestController
@RequestMapping("/katio/narrators")
@CrossOrigin(origins = "*")
public class NarratorController {

    @Autowired
    private NarratorRepository _narratorRepository;


   /**
    * 
    * @param narrators
    * @return Si se creo tu nuevo narrator
    *@return No se creo tu nuevo author badrequest
    */
    @PostMapping("/add")
    public ResponseEntity<Narrators> addNarrator(@RequestBody Narrators narrators) {
        try {
            Narrators createdNarrator = new NarratorService(_narratorRepository).addNarrators(narrators);
            return new ResponseEntity<>(createdNarrator, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * 
     * @param name
     * @param updateNarrator
     * @return Actualizo el narrator
     * @return No actualizo por noo encontrar el narrator
     */
    @PutMapping("/update/{name}")
    public ResponseEntity<Object> updateNarrator(@PathVariable("name") String name, @RequestBody Narrators updateNarrator) {
        Narrators updatedNarrator = new NarratorService(_narratorRepository).updateNarrators(name, updateNarrator);
        if (updatedNarrator != null) {
            return new ResponseEntity<>(updatedNarrator, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Narrador no Encontrado", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * 
     * @return todos los narradores existentes
     */
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Narrators>> getAllNarrators() {
        var narrators = new NarratorService(_narratorRepository).getAllNarrators();
        return new ResponseEntity<>(narrators, HttpStatus.OK);
    }


     /**
   * 
   * @param lastName
   * @return Narrador base el apellido 
   */
  @GetMapping("/getByLastName/{lastName}")
  public ResponseEntity<Iterable<Narrators>> getNarratorsByLastName(@PathVariable("lastName") String lastName) {
      var response = new NarratorService(_narratorRepository).getNarratorsByLastName(lastName);
      return new ResponseEntity<>(response, HttpStatus.OK);
  }

    /**
     * 
     * @param id
     * @return narrator por el id que se introdujo
     */
    @GetMapping("/getById/{id}")
    public ResponseEntity<Iterable<Narrators>> getNarratorsById(@PathVariable("id") Integer id) {
        var response = new NarratorService(_narratorRepository).getNarratorsById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

     /**
     * 
     * @param genre
     * @return Narrator por genero introducido 
     */
    @GetMapping("/getByGenre/{genre}")
    public ResponseEntity<Iterable<Narrators>> getNarratorsByGenre(@PathVariable("genre") String genre) {
        var response = new NarratorService(_narratorRepository).getNarratorsByGenre(genre);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


 

 


       /**
     * 
     * @param name
     * @return Nombre de el narrator ingresado 
     */
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Iterable<Narrators>> getNarratorsByName(@PathVariable("name") String name) {
        var response = new NarratorService(_narratorRepository).getNarratorsByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
   
}
