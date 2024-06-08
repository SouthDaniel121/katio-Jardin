package edu.eafit.katio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="book_author_view")
public class BooksAuthors {
    
    @Id
    @Column(name="book_id")
    private Long bookId;

    @Column(name="author_id")
    private long AuthorId;

    @Column(name="book_name")
    private String bookName;

    @Column(name="author_name")
    private String authorName;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public long getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(long authorId) {
        AuthorId = authorId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
