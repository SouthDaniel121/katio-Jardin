package edu.eafit.katio.interfaces;

import edu.eafit.katio.dto.BookByAuthor;
import edu.eafit.katio.models.Books;

public interface BaseBookService {
    Iterable<Books> getAllBooks();
    Iterable<Books> getAllBooksByAuthor(int idAuthor);
    Iterable<BookByAuthor> getAllBooksByAuthor(String Name, String Lastname);
    Iterable<Books> getBooksByName(String Name);

   
    Books getBookById(long id);
    Books addBook(Books book);
}

