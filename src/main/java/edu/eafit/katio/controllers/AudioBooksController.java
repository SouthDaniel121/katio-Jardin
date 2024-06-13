package edu.eafit.katio.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.models.AudioBooks;
import edu.eafit.katio.repository.AudioBooksRepository;
import edu.eafit.katio.services.AudioBookService;

@RestController
@RequestMapping("/katio/audbooks")
@CrossOrigin(origins = "*")
public class AudioBooksController {

    @Autowired
    //Aqui de declara el repositorio ↓
    private AudioBooksRepository _AudioBooksRepository;
    
    
    /**
     * 
     * @return Todos los Libros ↓
     */
    @GetMapping ("/getall")
    public ResponseEntity<Iterable<AudioBooks>> getallAudioBooks() 
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).getAllAudioBooks();
        return new ResponseEntity <Iterable<AudioBooks>> (audiobooks, HttpStatus.OK);
    }


      /**
     * 
     * @param author
     * @return retorna audio libros por el autor ↓
     */
    @GetMapping("/getByAuthor")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByAuthor(@RequestParam("author") String author)
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByAuthor(author);
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }


    /**
     * 
     * @param genre
     * @return Retorno audio libro base genero intro ↓
     */
    @GetMapping("/getByGenre")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByGenre(@RequestParam("genre") String genre)
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByGenre(genre);
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }

    /**
     * 
     * @param name
     * @return nombre por Audiolibro ↓
     */
    @GetMapping ("/getByName")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByName(@RequestParam("name") String name)
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByName(name);
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }

    /**
     * 
     * @param edition
     * @return edition del audio libro ↓
     */
    @GetMapping ("/getByEdition")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByEdition(@RequestParam("edition") String edition)
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByEdition(edition); 
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }



   

    /**
     * 
     * @param published
     * @return AudioLibro por fecha de publicacion ↓
     */
    @GetMapping("/getByPublished")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByPublishedDate(@RequestParam("published") Date published)
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByPublishedDate(published);
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }




    /**
     * 
     * @param duration
     * @return Libro por duracion coincidentes ↓
     */
    @GetMapping ("/getByLength")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByDuration(@RequestParam("duration") Long duration)
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByDuration(duration); 
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }


    /**
     * 
     * @param audioBooks
     * @return audioLibro retona creado ↓
     */
    @PostMapping ("/addaudiobooks")
    public ResponseEntity<AudioBooks> addAudioBooks(@RequestBody AudioBooks audioBooks)
    {
        var response = new AudioBookService(_AudioBooksRepository).createAudioBooks(audioBooks);
        return response.getId() == 0 ? new ResponseEntity<AudioBooks>(response, HttpStatus.BAD_REQUEST)
        : new ResponseEntity<AudioBooks>(response, HttpStatus.OK);
    }


   
    
}
