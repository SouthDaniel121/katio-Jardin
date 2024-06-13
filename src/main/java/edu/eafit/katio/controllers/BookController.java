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
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.dtos.BooksByAuthor;
import edu.eafit.katio.models.Books;
import edu.eafit.katio.repository.BookRepository;
import edu.eafit.katio.repository.BooksByAuthorRepository;
import edu.eafit.katio.services.BookService;


@RestController
@RequestMapping("/katio/books")
@CrossOrigin(origins = "*")
public class BookController {
    
    @Autowired
    private BookRepository _bookRepository;

    @Autowired //Se declara el repositorio
    private BooksByAuthorRepository _BooksByAuthorRepository;



    /**
     * 
     * @param books
     * @return 
     */
    @PostMapping("/add")
    public ResponseEntity<Books> addBooks(@RequestBody Books books) {
        try {
            Books creatBook = new BookService(_bookRepository) .addBooks(books);
            return new ResponseEntity<>(creatBook, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * 
     * @param name
     * @param updateBooks
     * @return libro actualizado 
     * @return No se encontro el libro
     */
    @PutMapping("/update/{name}")
    public ResponseEntity<Object> updateBooks(@PathVariable("name") String name, @RequestBody Books updateBooks) {
        Books updatedBook = new BookService(_bookRepository) .updateBook(name, updateBooks);
        if (updatedBook != null) {
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontro el libro", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * 
     * @return Todos los libros
     */
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Books>> getAllBooks() 
    {
        var books = new BookService(_bookRepository) .getAllBooks();
        return new ResponseEntity<Iterable<Books>>(books, HttpStatus.OK);
    }

 /**
     * 
     * @param nameAuthor
     * @return traer Libros por nombre del author
     */
    @GetMapping("/getByAuthorName/{Name}")
    public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthorName(@PathVariable("Name") String nameAuthor) 
    {
        var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthorName(nameAuthor);
        return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
    }

    /**
     * 
     * @param nameAuthor
     * @param lastNameAuthor
     * @return trae libros por nombre completo del author
     */
    @GetMapping("/getByAuthor/{Name}/{LastName}")
    public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthor(@PathVariable("Name") String nameAuthor, @PathVariable("LastName") String lastNameAuthor)
    {
        var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthor(nameAuthor, lastNameAuthor);
        return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
    }

    /**
     * 
     * @param Id
     * @return libros introducido por id (/getById/1)
     */
    @GetMapping("/getById/{Id}")
    public ResponseEntity<Iterable<Books>> getBooksById(@PathVariable ("Id") Integer Id)
    {
        var response = new BookService(_bookRepository).getBooksById(Id);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }

   /**
    * 
    * @param Name
    * @return libro por busqueda por nombre
    */
    @GetMapping("/getByName/{Name}")
    public ResponseEntity<Iterable<Books>> getBookByName(@PathVariable ("Name") String Name)
    {
        var response = new BookService(_bookRepository).getBooksByName(Name);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }

   /**
    * 
    * @param Edition
    * @return Traer Libros por editorial 
    */
    @GetMapping("/getByEdition/{Edition}")
    public ResponseEntity<Iterable<Books>> getBooksByEdition(@PathVariable ("Edition") String Edition)
    {
        var response = new BookService(_bookRepository).getBooksByEdition(Edition);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }

    /**
     * 
     * @param Genre
     * @return libro por genero introducido
     */
    @GetMapping("/getByGenre/{Genre}")
    public ResponseEntity<Iterable<Books>> getBooksByGenre(@PathVariable ("Genre") String Genre)
    {
        var response = new BookService(_bookRepository).getBooksByGenre(Genre);
        return new ResponseEntity<Iterable<Books>> (response, HttpStatus.OK);
    }



   /**
    * 
    * @param startDate
    * @param endDate
    * @return Libro por fecha. Es un rango de fechas.
    */
    @GetMapping("/getByDate/{startDate}/{endDate}")
    public ResponseEntity<List<Books>> getBooksByDate(
            @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        var response = new BookService(_bookRepository).getBooksByDateRange(startDate, endDate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 
     * @param idAuthor
     * @return author por el id introducido
     */
    @GetMapping("/getByAuthorId/{Id}")
    public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthorId(@PathVariable("Id") Integer idAuthor)
    {
        var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthorId(idAuthor);
        return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
    }

   
}
