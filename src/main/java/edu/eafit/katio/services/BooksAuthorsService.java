package edu.eafit.katio.services;

import edu.eafit.katio.interfaces.BaseBooksAuthorsService;
import edu.eafit.katio.models.BooksAuthors;
import edu.eafit.katio.repository.BooksAuthorRepository;

public class BooksAuthorsService implements BaseBooksAuthorsService {

    private BooksAuthorRepository _booksAuthorRepository;

    public BooksAuthorsService(BooksAuthorRepository booksAuthorRepository) {
        _booksAuthorRepository = booksAuthorRepository;
    }

    @Override
    public Iterable<BooksAuthors> getAllBooksAuthors() {
        return _booksAuthorRepository.findAllByBooks();
    }
    
}
