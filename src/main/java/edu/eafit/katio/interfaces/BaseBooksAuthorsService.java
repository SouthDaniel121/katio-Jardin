package edu.eafit.katio.interfaces;

import edu.eafit.katio.models.BooksAuthors;

public interface BaseBooksAuthorsService {
    Iterable<BooksAuthors> getAllBooksAuthors();
}
