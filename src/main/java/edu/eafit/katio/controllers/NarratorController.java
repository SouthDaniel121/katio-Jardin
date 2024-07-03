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
import edu.eafit.katio.repositories.NarratorRepository;
import edu.eafit.katio.services.NarratorService;

@RestController
@RequestMapping("/katio/narrators")
@CrossOrigin(origins = "*")
public class NarratorController {

    @Autowired
    private NarratorRepository _narratorRepository;


  

        /**
     * Metodo GET
     * Este controlador nos sirve para poder traer todo los 
     * @return todos los narradores que hay en la db (Registrados | Existentes )
     */
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Narrators>> getAllNarrators() {
        var narrators = new NarratorService(_narratorRepository).getAllNarrators();
        return new ResponseEntity<>(narrators, HttpStatus.OK);
    }


    /**
     * Metodo Post Actualizacion
     * Este controlador nos sirve para actualizar o cambiar cualquier informacion del narrador
     * @param name
     * @param updateNarrator
     * @return narrador no encontrado 
     */
    @PostMapping("/update/{name}")
    public ResponseEntity<Object> updateNarrator(@PathVariable("name") String name, @RequestBody Narrators updateNarrator) {
        Narrators updatedNarrator = new NarratorService(_narratorRepository).updateNarrators(name, updateNarrator);
        if (updatedNarrator != null) {
            return new ResponseEntity<>(updatedNarrator, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Narrador no Encontrado", HttpStatus.NOT_FOUND);
        }
    }


      /**
     * Metodo Put crear
     * Este contorlador nos sirve para crear un nuevo narrador 
     * @param narrators
     * @return Narrator creado 
     * @return Narrador no creado 
     */
    @PutMapping("/add")
    public ResponseEntity<Narrators> addNarrator(@RequestBody Narrators narrators) {
        try {
            Narrators createdNarrator = new NarratorService(_narratorRepository).addNarrators(narrators);
            return new ResponseEntity<>(createdNarrator, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


        /**
     * Metodo Get
     * Este controlador nos sirve para traer por el apellido del narrador por si no se sabe el name.
     * @param lastName
     * @return Apellido == Apellido ingresado. (Por el postman)
     */
    @GetMapping("/getByLastName/{lastName}")
    public ResponseEntity<Iterable<Narrators>> getNarratorsByLastName(@PathVariable("lastName") String lastName) {
        var response = new NarratorService(_narratorRepository).getNarratorsByLastName(lastName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Metodo Get
     * Este controlador nos sirve para poder traer los narradores que hay por genero 
     * @param genre
     * @return Generos == Genero ingresado. (Por el postman)
     */
    @GetMapping("/getByGenre/{genre}")
    public ResponseEntity<Iterable<Narrators>> getNarratorsByGenre(@PathVariable("genre") String genre) {
        var response = new NarratorService(_narratorRepository).getNarratorsByGenre(genre);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    /**
     * Metodo GET
     * Este controlador nos permite traer por un numero especifico.
     * @param id
     * @return id narrador == id narrador ingresado. (Por el postman)
     */
    @GetMapping("/getById/{id}")
    public ResponseEntity<Iterable<Narrators>> getNarratorsById(@PathVariable("id") Integer id) {
        var response = new NarratorService(_narratorRepository).getNarratorsById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    

    /**
     * Metodo GET
     * Este controlador nos permite traer por un nombre especifico.
     * @param name
     * @return Nombre narrator == Nombre narrator ingresado. (Por el postman)
     */
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Iterable<Narrators>> getNarratorsByName(@PathVariable("name") String name) {
        var response = new NarratorService(_narratorRepository).getNarratorsByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
