package edu.eafit.katio.interfaces;

import java.util.Optional;

import edu.eafit.katio.models.Authors;

public interface BaseAuthorService {
    Iterable<Authors> getAllAuthors();
    Optional<Authors> getAuthorById(Long id);
    Authors addAuthor(Authors authors);
     Iterable<Authors> findByCountry(String country);

}
