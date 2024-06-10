package edu.eafit.katio.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.models.Authors;
import edu.eafit.katio.repository.AuthorRepository;
import edu.eafit.katio.services.AuthorService;




/* 
*    Paths ↓ 
*    Get → http://localhost:8080/katio/authors/getall Sirve
*    POST → http://localhost:8080/katio/authors/add sirve
*    Get →  http://localhost:8080/katio/authors/get_by_id/{id} sirve
*    Get → http://localhost:8080/katio/authors/getByName/{name}
*    Get → http://localhost:8080/katio/authors/country/{pais} Sirve
*     (Solo para facilitar la busqueda NO debe ir aqui esto,temas de seguridad).
 */


 @RestController
 @RequestMapping("/katio/authors")
 @CrossOrigin(origins = "*") 
public class AuthorsController {
    @Autowired
    private AuthorRepository _authorRepository;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<Authors>> getAllAuthors() {
        var authors = _authorRepository.findAll();
        return new ResponseEntity<Iterable<Authors>>(authors, HttpStatus.OK);
    }
    


    /**
     * Metodo postt para agregar autores
     * @param author
     * @return author creado
     */
    @PostMapping("/add")
    public ResponseEntity<?> addAuthor(@RequestBody Authors author) {
        var service = new AuthorService(_authorRepository);
        Authors createdAuthor = service.addAuthor(author);
        

        if (createdAuthor.getId() == 0) {
            return ResponseEntity.badRequest().body(createdAuthor);
        }

        return ResponseEntity.ok(createdAuthor);
    }
  

     /**
      * 
      * @param id
      * @return id del author
      * Metodo Get para traer por id 
      */
    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<Authors> getAuthorById(@PathVariable Long id) {
        Optional<Authors> author = new AuthorService(_authorRepository).getAuthorById(id);
        return ResponseEntity.of(author);
    }


      /**
       * 
       * @param name
       * @return name author
       * Metodo get para traer por name de author
       */
      @GetMapping("/getByName/{name}")
      public ResponseEntity<Iterable<Authors>> getAuthorsByName(@PathVariable String name) {
          Iterable<Authors> authors = new AuthorService(_authorRepository).findByName(name);
          return ResponseEntity.ok(authors);
      }
  
  
      /**
       * 
       * @param pais
       * @return pais por authores
       */
      @GetMapping("/country/{pais}")
      public ResponseEntity<Iterable<Authors>> getAuthorByCountry(@PathVariable String pais) {
          Iterable<Authors> authors = new AuthorService(_authorRepository) .findByCountry(pais);
          return ResponseEntity.ok(authors);
      }


    //PUT falta editar author.
      
      //GET Falta por fecha de nacimiento.

}
