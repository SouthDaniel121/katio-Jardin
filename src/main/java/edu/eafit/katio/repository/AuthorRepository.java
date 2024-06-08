package edu.eafit.katio.repository;

import org.springframework.data.repository.CrudRepository;

import edu.eafit.katio.models.Authors;

public interface AuthorRepository extends CrudRepository<Authors, Long> {
    
    Authors saveAndFlush(Authors authors);

    Iterable<Authors> findByCountry(String country);

    Iterable<Authors> getAuthorsByName(String name);

    
}
