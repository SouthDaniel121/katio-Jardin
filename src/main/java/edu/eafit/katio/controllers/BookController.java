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
import edu.eafit.katio.dtos.GenreInsertdto;
import edu.eafit.katio.models.Books;
import edu.eafit.katio.repositories.BookRepository;
import edu.eafit.katio.repositories.BooksByAuthorRepository;
import edu.eafit.katio.repositories.GenreByBookRepository;
import edu.eafit.katio.services.BookService;


@RestController
@RequestMapping("/katio/books")
@CrossOrigin(origins = "*")
public class BookController {
    
    @Autowired
    private BookRepository _bookRepository;

    @Autowired
    private BooksByAuthorRepository _BooksByAuthorRepository;

    @Autowired
    private GenreByBookRepository _GenreByBookRepository;





      // BooksByAuthor

    /**
     * Metodo GET
     * Este controlador nos sirve para conocer todos los libros por el author
     * @param idAuthor
     * @return → Libros por id del author
     */
  
     @GetMapping("/getByAuthorId/{Id}")
     public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthorId(@PathVariable("Id") Integer idAuthor)
     {
         var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthorId(idAuthor);
         return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
     }
 
     /**
      * Metodo GET
      * Nos ayuda a traer libnro por nombre de author
      * @param nameAuthor
      * @return → books por nombre == nombre del libro ingresado. (Por Postman)
      */
     @GetMapping("/getByAuthorName/{Name}")
     public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthorName(@PathVariable("Name") String nameAuthor) 
     {
         var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthorName(nameAuthor);
         return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
     }
 
     /**
      * Metodo GET 
      * Este controlador nos ayuda a buscar por nombre y apellido del author
      * @param nameAuthor
      * @param lastNameAuthor
      * @return nombre de author == Libros por nombre de author ingresado. (Por Postman)
      */
     // Traer Libros por Nombre y Apellido del Autor
     @GetMapping("/getByAuthor/{Name}/{LastName}")
     public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthor(@PathVariable("Name") String nameAuthor, @PathVariable("LastName") String lastNameAuthor)
     {
         var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthor(nameAuthor, lastNameAuthor);
         return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
     }
 
     /**
      * Metodo Post Crear
      * Esto nos sirve para crear un nuevo genero de libro en la db 
      * @param genre
      * @return Genero No creado 
      * @return Genero Creado 
      */
     @PostMapping("/addGenres")
     public ResponseEntity<?> addGenres(@RequestBody GenreInsertdto genre){
         var response = new BookService(_bookRepository, _GenreByBookRepository).addGenre(genre);
         if(!response){
             return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
         }
         return new ResponseEntity<>(response, HttpStatus.OK);
     }
 






    //Libros


   
    /**
     * 
     * Metodo POST Actualizacion
     * Este controlador es para crear un libro nuevo
     * @param books
     * @return Libro Creado
     * @return Libro No Creado
     */
    @PutMapping("/add")
    public ResponseEntity<Books> addBooks(@RequestBody Books books) {
        try {
            Books creatBook = new BookService(_bookRepository) .addBooks(books);
            return new ResponseEntity<>(creatBook, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    

    /**
     * METODO Post actualizar
     * Nos sirve para poder actualizar o cambiar algun dato del un libro.
     * @param name
     * @param updateBooks
     * @return → Book == Book actualizado.
     */
    @PostMapping("/update/{name}")
    public ResponseEntity<Object> updateBooks(@PathVariable("name") String name, @RequestBody Books updateBooks) {
        Books updatedBook = new BookService(_bookRepository) .updateBook(name, updateBooks);
        if (updatedBook != null) {
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Libro no Encontrado", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo GET
     * Nos sirve para ver todos los libros existentes 
     * @return → Todos los libros existentes en la db 
     */
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Books>> getAllBooks() 
    {
        var books = new BookService(_bookRepository) .getAllBooks();
        return new ResponseEntity<Iterable<Books>>(books, HttpStatus.OK);
    }

    /**
     * Metodo GET
     * Nos sirve para traer un libro especifico y unico
     * @param Id
     * @return → Traer libro == Id libro ingresado. (POR POSTMAN)
     */
    @GetMapping("/getById/{Id}")
    public ResponseEntity<Iterable<Books>> getBooksById(@PathVariable ("Id") Integer Id)
    {
        var response = new BookService(_bookRepository).getBooksById(Id);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }

    /**
     * Metodo GET
     * Traer libro por nombre ingresado 
     * @param Name
     * @return → Libros por nombre == nombre ingresado (Por postman)
     */
    @GetMapping("/getByName/{Name}")
    public ResponseEntity<Iterable<Books>> getBookByName(@PathVariable ("Name") String Name)
    {
        var response = new BookService(_bookRepository).getBooksByName(Name);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }



    /**
     * Metodo GET
     * Este controlador nos sirve para traer los libros por edition
     * @param Edition
     * @return → Edition libro == libro edition ingresada. (Por Postman)
     */
    @GetMapping("/getByEdition/{Edition}")
    public ResponseEntity<Iterable<Books>> getBooksByEdition(@PathVariable ("Edition") String Edition)
    {
        var response = new BookService(_bookRepository).getBooksByEdition(Edition);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }



    /**
     * Metodo GET
     * Este controlador nos sirve para traer libros por el genero 
     * @param Genre
     * @return → libros con genero == libros por genero ingresado. (Por Postman)
     */
    @GetMapping("/getByGenre/{Genre}")
    public ResponseEntity<Iterable<Books>> getBooksByGenre(@PathVariable ("Genre") String Genre)
    {
        var response = new BookService(_bookRepository).getBooksByGenre(Genre);
        return new ResponseEntity<Iterable<Books>> (response, HttpStatus.OK);
    }

    /**
     * Metodo GET
     * Esto controlador nos sirve para poder tener un libro por rango de fechas minima  maxima
     * @param startDate
     * @param endDate
     * @return → libros con Rango de fechas minima y maxima
     */
    @GetMapping("/getByDate/{startDate}/{endDate}")
    public ResponseEntity<List<Books>> getBooksByDate(
            @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        var response = new BookService(_bookRepository).getBooksByDateRange(startDate, endDate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
