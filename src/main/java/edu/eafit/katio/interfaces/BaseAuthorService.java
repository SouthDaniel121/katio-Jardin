package edu.eafit.katio.interfaces;

import java.util.List;

import edu.eafit.katio.dtos.AudioBooksByAuthor;
import edu.eafit.katio.models.Authors;

public interface BaseAuthorService {
     List<Authors> getAuthorById(Integer id);
     List<Authors> getAuthorByName(String name);
     List<Authors> getAuthorByCountry(String country);


     Authors addAuthors(Authors authors);

     Authors updateAuthor(String name, Authors updateAuthors);

     List<AudioBooksByAuthor> getAllAudioBooksByAuthorId(Integer idAuthor);
     List<AudioBooksByAuthor> getAllAudioBooksByAuthorName(String nameAuthor);
     List<AudioBooksByAuthor> getAllAudioBooksByAuthor(String nameAuthor, String lastNameAuthor);
}
