package edu.eafit.katio.interfaces;

import java.util.List;

import edu.eafit.katio.dtos.BooksByAuthor;
import edu.eafit.katio.dtos.GenreInsertdto;
import edu.eafit.katio.models.Books;

public interface BaseBookService {
    Iterable<Books> getAllBooks();
    Iterable<Books> getBooksByName(String Name);
    List<Books> getBooksByEdition(String Name);
    List<Books> getBooksByGenre(String Genre);
    List<Books> getBooksById(Integer Id);

    Books addBooks(Books books);

    Books updateBook(String name, Books updateBooks);

    boolean addGenre(GenreInsertdto genreInsertdto);

    List<BooksByAuthor> getAllBooksByAuthorId(Integer idAuthor);
    List<BooksByAuthor> getAllBooksByAuthorName(String nameAuthor);
    List<BooksByAuthor> getAllBooksByAuthor(String nameAuthor, String lastNameAuthor);
}