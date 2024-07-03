package edu.eafit.katio.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.dtos.AudioBooksByAuthor;
import edu.eafit.katio.models.Authors;
import edu.eafit.katio.repositories.AudioBooksByAuthorRepository;
import edu.eafit.katio.repositories.AuthorRepository;
import edu.eafit.katio.services.AuthorService;



@RestController
@RequestMapping("/katio/authors")
@CrossOrigin(origins = "*")
public class AuthorsController {
    @Autowired
    private AuthorRepository _authorRepository;

    @Autowired
    private AudioBooksByAuthorRepository _AudioBooksByAuthorRepository;



//SE COMPARTE CON EL DE AUDIO LIBROS***********




    /**
     * METODO GET
     * Este controlador sirve para poder devolver todo los autores registrados.
     * @return → Todos los existentes.
     */
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Authors>> getAllAuthors() {
        var authors = _authorRepository.findAll();
        return new ResponseEntity<Iterable<Authors>>(authors, HttpStatus.OK);
    }
    
    /**
     * METODO GET
     * Este controlador sirve para poder traer author por id dado a la hora de crearlo.
     * En forma AutoIncrementable 
     * @param id
     * @return →  Id de author  == Id Ingresado. (EN EL POSTMAN)
     */
    @GetMapping("/getById")
    public ResponseEntity<Iterable<Authors>> getAuthorById(@RequestParam("id") Integer id) 
    {
        var authorById = new AuthorService(_authorRepository).getAuthorById(id);
        return new ResponseEntity<Iterable<Authors>>(authorById, HttpStatus.OK);
    }



        /**
     * 
     * METODO GET
     * Este controlador sirve para poder traer authores por dia de nacimiento o birhtdate.↓
     * @param startDate
     * @param endDate
     * @return → Rango == las dos fechas en rango  Ingresadas. (En el PostMan)
     * 
     * 
     */
    @GetMapping("/getByDate/{startDate}/{endDate}")
    public ResponseEntity<List<Authors>> getAuthorsByDate(
        @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
        @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        var response = new AuthorService(_authorRepository).getAuthorsByDateRange(startDate, endDate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * METODO PUT CREAR
     * Este controlador nos sirve para CREAR un NUEVO author.
     * @param authors
     * @return → Author creado
     * @return → No se creo, No envio datos , Lleno mal o incompletos los campos designados en el model.
     */
    @PutMapping("/add")
    public ResponseEntity<Authors> addAuthors(@RequestBody Authors authors) {
        try {
            Authors createAuthor = new AuthorService(_authorRepository) .addAuthors(authors);
            return new ResponseEntity<>(createAuthor, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }




    /**
     * METODO GET
     * Este controlador es para poder encontrar author por el nombre.
     * @param name
     * @return → Nombre del author == Nombre INGRESADO. (EN EL POSTMAN)
     */
    @GetMapping("/getByName")
    public ResponseEntity<Iterable<Authors>> getAuthorByName(@RequestParam("name") String name) 
    {
        var authorByName = new AuthorService(_authorRepository).getAuthorByName(name);
        return new ResponseEntity<Iterable<Authors>>(authorByName, HttpStatus.OK);
    }

    /**
     * METODO GET 
     * Este controlador nos sirve para traer authores por un mismo pais. ↓
     * @param country
     * @return → PAIS == Pais Ingresado. (EN EL POSTMAN)
     */
    @GetMapping("/getByCountry")
    public ResponseEntity<Iterable<Authors>> getAuthorByCountry(@RequestParam("country") String country) {
        var authorByCountry = new AuthorService(_authorRepository).getAuthorByCountry(country);
        return new ResponseEntity<Iterable<Authors>>(authorByCountry, HttpStatus.OK);
    }



//-------------------→ALGUNOS METODOS COMPARTE AUDIO LIBROS BY AUTHOR←-------------------------------------------------------

        /**
     * METODO GET
     * Dto de bookByAuthor
     *  Este controlador nos sirve para poder traer id por author 
     * @param idAuthor
     * @return Audio libro por author == Id author . (Si existe)
     */
    @GetMapping("/getByAuthorId")
    public ResponseEntity<Iterable<AudioBooksByAuthor>> getAllAudioBooksByAuthorId(@PathVariable("Id") Integer idAuthor){
        var response = new AuthorService(_AudioBooksByAuthorRepository).getAllAudioBooksByAuthorId(idAuthor);
        return new ResponseEntity<Iterable<AudioBooksByAuthor>>(response, HttpStatus.OK);
    }




    /**
     * METODO GET
     * Este controlador nos sirve para poder traer los AudioLibros por Nombre de author
     * @param nameAuthor
     * @return → Nombre de author == AudioLibro * Nombre author 
     */
    // Traer AudioLibros por Nombre del Autor
    @GetMapping("/getByAuthorName/{Name}")
    public ResponseEntity<Iterable<AudioBooksByAuthor>> getAllAudioBooksByAuthorName(@PathVariable("Name") String nameAuthor) 
    {
        var response = new AuthorService(_AudioBooksByAuthorRepository).getAllAudioBooksByAuthorName(nameAuthor);
        return new ResponseEntity<Iterable<AudioBooksByAuthor>>(response, HttpStatus.OK);
    }


    /**
     * METODO GET 
     * Este controlador nos sirve para poder traer un audioLibro  por nombre de author o apellido
     * @param nameAuthor
     * @param lastNameAuthor
     * @return → Nombre o Apellido == AudioLibro * el nombre o apellido
     */
    // Traer AudioLibros por Nombre y Apellido del Autor
    @GetMapping("/getByAuthor/{Name}/{LastName}")
    public ResponseEntity<Iterable<AudioBooksByAuthor>> getAllAudioBooksByAuthor(@PathVariable("Name") String nameAuthor, @PathVariable("LastName") String lastNameAuthor)
    {
        var response = new AuthorService(_AudioBooksByAuthorRepository).getAllAudioBooksByAuthor(nameAuthor, lastNameAuthor);
        return new ResponseEntity<Iterable<AudioBooksByAuthor>>(response, HttpStatus.OK);
    }






    /**
     * METODO POST ACTUALIZAR
     * Este controlador nos permite cambiar informacion o actualizar sobre el author.
     * @param name
     * @param updateAuthors
     * @return → Usuario Actualizado
     * @return → Usuario no creado, No existe o Mal ingresado los nuevos datos.
     */
    @PostMapping("/update/{name}")
    public ResponseEntity<Object> updateAuthors(@PathVariable("name") String name, @RequestBody Authors updateAuthors) {
        Authors updatedAuthors = new AuthorService(_authorRepository) .updateAuthor(name, updateAuthors);
        if (updatedAuthors != null) {
            return new ResponseEntity<>(updatedAuthors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Autor no Encontrado", HttpStatus.NOT_FOUND);
        }
    }





}