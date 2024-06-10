package edu.eafit.katio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eafit.katio.models.Authors;

@Repository
public interface AuthorRepository extends JpaRepository<Authors, Long> {
    
    Authors saveAndFlush(Authors authors);

    @Query("SELECT a FROM Authors a WHERE a.name = :name")
    Iterable<Authors> getAuthorsByName(@Param("name") String name);

    @Query("SELECT A FROM Authors a WHERE a.country =:country")
    Iterable<Authors> findByCountry(String country);

    Iterable<Authors> findByName(String name);


    
}
