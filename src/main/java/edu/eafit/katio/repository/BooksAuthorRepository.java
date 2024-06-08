package edu.eafit.katio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.eafit.katio.models.BooksAuthors;

public interface BooksAuthorRepository  extends JpaRepository<BooksAuthors, Long>{
    @Query(nativeQuery = true, value = "SELECT * FROM book_author_view")
    Iterable<BooksAuthors> findAllByBooks();
}
