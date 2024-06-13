package edu.eafit.katio.services;

import java.util.Optional;

import edu.eafit.katio.interfaces.BaseAuthorService;
import edu.eafit.katio.models.Authors;
import edu.eafit.katio.repository.AuthorRepository;

public class AuthorService implements BaseAuthorService {

    private AuthorRepository _AuthorRepository;

    public AuthorService(AuthorRepository _AuthorRepository) {
        this._AuthorRepository = _AuthorRepository;
    
    }

    @Override
    public Authors addAuthors(Authors authors) {
        return _AuthorRepository.save(authors);
        
    }

    @Override
    public Optional<Authors> getAuthorById(Long id) {
        return _AuthorRepository.findById(id);
       
    }

    @Override
    public Iterable<Authors> getAuthorByName(String name) {
        return _AuthorRepository.findByName(name);
       
    }

    @Override
    public Iterable<Authors> getAuthorByCountry(String country) {
        return _AuthorRepository.findByCountry(country);
        
    }
}
