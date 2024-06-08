package edu.eafit.katio.services;

import java.util.Optional;

import edu.eafit.katio.interfaces.BaseAuthorService;
import edu.eafit.katio.models.Authors;
import edu.eafit.katio.repository.AuthorRepository;

public class AuthorService implements BaseAuthorService {

    private AuthorRepository _AuthorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        _AuthorRepository = authorRepository;
    }

    @Override
    public Iterable<Authors> getAllAuthors() {
        var authorList = _AuthorRepository.findAll();
        return authorList;
    }


    @Override
    public Authors addAuthor(Authors author) {
        return _AuthorRepository.save(author);
    }

    
    @Override
    public Iterable<Authors> findByCountry(String country) {
        return _AuthorRepository.findByCountry(country);
    }

    public Iterable<Authors> getAuthorsByName(String name) {
        return _AuthorRepository.getAuthorsByName(name);
    }

    @Override
    public Optional<Authors> getAuthorById(Long id) {
        return _AuthorRepository.findById(id);
    }

 
    
}
