package edu.eafit.katio.interfaces;

import java.util.Optional;


import edu.eafit.katio.models.Authors;

public interface BaseAuthorService {

     Authors addAuthors(Authors authors);
     Optional<Authors> getAuthorById(Long id);
     Iterable<Authors> getAuthorByName(String name);
     Iterable<Authors> getAuthorByCountry(String country);
}
