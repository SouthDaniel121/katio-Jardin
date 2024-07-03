package edu.eafit.katio.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.dtos.AudioBooksDTO;
import edu.eafit.katio.models.AudioBooks;
import edu.eafit.katio.repositories.AudioBooksRepository;
import edu.eafit.katio.repositories.AudioBooks_AuthorsRepository;
import edu.eafit.katio.repositories.AudioBooks_GenreRepository;
import edu.eafit.katio.services.AudioBookService;


@RestController
@RequestMapping("/katio/audiobooks")
@CrossOrigin(origins = "*")
public class AudioBooksController {

    @Autowired
    private AudioBooksRepository _AudioBooksRepository;

    @Autowired
    private AudioBooks_AuthorsRepository _AudioBooks_AuthorsRepository;

    @Autowired
    private AudioBooks_GenreRepository _AudioBooks_GenreRepository;



    /**
     * @return → todos los audiolibros que hay en la base de datos.
     * Este controlador se encarga por metodo GET de traer todo los audiolibros.↓
     */
    @GetMapping ("/getall")
    public ResponseEntity<Iterable<AudioBooks>> getallAudioBooks() 
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).getAllAudioBooks();
        return new ResponseEntity <Iterable<AudioBooks>> (audiobooks, HttpStatus.OK);
    }



    /**
     * Este controlador se encarga de traer con el metodo GET  por duracion del audiolibro ↓
     * @param duration
     * @return → duration del audiolibro parametros→(Lista de duracion)
     */
    @GetMapping ("/getByLength")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByDuration(@RequestParam("duration") Long duration)
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByDuration(duration); 
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }



    
    /**
     * Este controlador se encarga por metodo GET de traer libro por nombre.↓
     * @param name
     * @return →  nameAudiolibro ingresado. (EN EL POSTMAN)
     */
    @GetMapping ("/getByName")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByName(@RequestParam("name") String name){
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByName(name);
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }



    /**
     *  Este controlador se encarga de traer con metodo GET por la edition del audiolibro.↓
     * @param edition
     * @return → edition audiolibro ingresado. (EN EL POSTMAN)
     */
    @GetMapping ("/getByEdition")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByEdition(@RequestParam("edition") String edition){
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByEdition(edition); 
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }




   /**
     * Este controlador se encarga  de actualizar los datos ingresados en un libro YA CREADO.
     * Por metodo Post que significa actualizacion.↓
     *  @param audioBooks
     * @return → audiolibro no actualizado. Fallas en el ingreso de datos
     * @return → Audio libro actualizado 
     */
    @PostMapping ("/update-audiobooks")
    public ResponseEntity<AudioBooks> updateAudioBooks(@RequestBody AudioBooksDTO audioBooks){
        var response = new AudioBookService(_AudioBooksRepository, _AudioBooks_AuthorsRepository, _AudioBooks_GenreRepository).updateAudioBooks(audioBooks);
        return response == null || response.getId() == 0? new ResponseEntity<AudioBooks>(response, HttpStatus.BAD_REQUEST)
        : new ResponseEntity<AudioBooks>(response, HttpStatus.OK);
    }



    /**
     *  Este controlador se encargar de crear libros por metodo PUT QUE ES CREA. ↓
     * @param audioBooks
     * @return audiolibro no creado. Fallas en el ingreso de datos
     * @return → Audio libro creado
     */
    @PutMapping ("/addaudiobooks")
    public ResponseEntity<AudioBooks> addAudioBooks(@RequestBody AudioBooksDTO audioBooks){
        var response = new AudioBookService(_AudioBooksRepository, _AudioBooks_AuthorsRepository, _AudioBooks_GenreRepository).createAudioBooks(audioBooks);
        return response == null || response.getId() == 0? new ResponseEntity<AudioBooks>(response, HttpStatus.BAD_REQUEST)
        : new ResponseEntity<AudioBooks>(response, HttpStatus.OK);
    }



    /**
     * METODO GET
     *  Este controlador sirve para buscar libro por fecha de publicacion ↓
     * (Deberia ser por el que lo publico, pero es por la fecha).
     * @param published
     * @return → fecha en la que se publico el audiolibro
     */
    @GetMapping("/getByPublished")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByPublishedDate(@RequestParam("published") Date published)
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByPublishedDate(published);
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }




    /**
     * Este controlador nos trae con metodo GET el author que le ingresemos 
     * @param author
     * @return → AudioLibro → Author por el ID
     */
    @GetMapping("/getByAuthor")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByAuthor(@RequestParam("authorId") String author)
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByAuthor(author);
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }


    /**
     * Por metodo GET
     * Este controlador sirve para traer los genero. (pedido PostMan )
     * @param genre
     * @return → genero pedido.  (por el PostMan )
     */
    @GetMapping("/getByGenre")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByGenre(@RequestParam("genreId") String genre)
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByGenre(genre);
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }


 
    
}
