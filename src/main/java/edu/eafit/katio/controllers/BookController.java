package edu.eafit.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.dto.BookByAuthor;
import edu.eafit.katio.models.Books;
import edu.eafit.katio.models.BooksAuthors;
import edu.eafit.katio.repository.BookRepository;
import edu.eafit.katio.repository.BooksAuthorRepository;
import edu.eafit.katio.repository.BooksByAuthorRepository;
import edu.eafit.katio.services.BookService;
import edu.eafit.katio.services.BooksAuthorsService;



/*
*     Paths ↓
*     Get → http://localhost:8080/katio/books/getall
*     Get → http://localhost:8080/katio/books/getById/{id}
*     Post → http://localhost:8080/katio/books/add
*     Get → http://localhost:8080/katio/books/getByName/{name}
*     Get → http://localhost:8080/katio/books/getByEditorial/{editorial}
*     (Solo para facilitar la busqueda no deberia ir aqui esto,temas de seguridad).
 */


 
 @RestController
 @RequestMapping("/katio/books")
 @CrossOrigin(origins = "*") 
public class BookController {
    
    @Autowired
    private BookRepository _bookRepository;

    @Autowired
    private BooksByAuthorRepository _BooksByAuthorRepository;

    @Autowired 
    BooksAuthorRepository _BooksAuthorRepository;


    /**
     * 
     * @return Traer todos los libros.
     */
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Books>> getAllBooks() {
        var books = new BookService(_bookRepository).getAllBooks();
        return new ResponseEntity<Iterable<Books>>(books, HttpStatus.OK);
    }



    /**
     * 
     * @param id
     * @return Author por id.
     */
    @GetMapping("/getByAuthor/{id}")
    public ResponseEntity<Iterable<Books>> getAllBooksByAuthor(@RequestParam Integer id)
    {
        var response = new BookService(_bookRepository).getAllBooksByAuthor(id);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }



    /**
     * 
     * @param name
     * @param lastname
      * @return Libros por el nombre de author.
     */
    @GetMapping("/getByAuthor/{name}/{lastname}")
    public ResponseEntity<Iterable<BookByAuthor>> getAllBookByAuthor(@PathVariable("name") String name, @PathVariable("lastname") String lastname)
    {
        var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthor(name, lastname);
        return new ResponseEntity<Iterable<BookByAuthor>>(response, HttpStatus.OK);
    }


    /**
     * 
     * @param book
     * @return Nombre del libro 
     */
    @GetMapping("/getBooksByName/{NameBook}")
    public ResponseEntity<Iterable<Books>> getBookByName(@RequestBody Books book) {
        var response = new BookService(_bookRepository).getBooksByName(book.getName());
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }
    


    /**
     * 
     * @return Libros por author
     */
    @GetMapping("/getBooksByAuthor/{BookByAuthor}")
    public ResponseEntity<Iterable<BooksAuthors>> getBooksByAuthor(){
        var response = new BooksAuthorsService(_BooksAuthorRepository).getAllBooksAuthors();
        return new ResponseEntity<Iterable<BooksAuthors>>(response, HttpStatus.OK);
    }



    /**
     * 
     * @param fechaInicio
     * @param fechaFin
     * @return libros por esa fecha 
     */
    @GetMapping("/getBooksByRange/{FechaLibro}")
    public ResponseEntity<?> getBooksByDateRange(@RequestParam String fechaInicio, @RequestParam String fechaFin){
        System.out.println("la fecha inicial: " + fechaInicio.toString() + " La fecha final" + fechaFin.toString());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    
    /**
     * 
     * 
     * @param book
     * @return Book creado
     */
    @PostMapping("/add")
    public ResponseEntity<Books> addBook(@RequestBody Books book) {
    Books createdBook = new BookService(_bookRepository).addBook(book);
    
    return createdBook.getId() == 0 ? 
            ResponseEntity.badRequest().body(createdBook) :
            ResponseEntity.ok(createdBook);
    }


         /**
          * 
          * @param editorial
          * @return libro base a la editorial nombrada
          */
         @GetMapping("/getByEdition/{edition}")
         public ResponseEntity<Iterable<Books>> getEdition(@PathVariable String editorial) {
             Iterable<Books> response = new BookService(_bookRepository).getBooksByEdition(editorial);
             return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * 
     * Get All Books ✔
     * get All Books By Author Name or Last name ✔
     * Get All Books By Author ID ✔
     * Create new Book ✔
     * Edit Existing Book by ID
     * Search book by ISBN 
     * Search Book by ISBN13
     * Search books by Date 
     * Search books by Genre
     */
    
}
