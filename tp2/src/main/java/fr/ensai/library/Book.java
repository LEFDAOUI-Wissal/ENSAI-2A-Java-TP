package fr.ensai.library;

/**
 * Represents a book.
 */

class Book extends Item {
    
}
public class Book extends Item  {

    private String isbn;
    private Author author;

    public Book(String isbn, String title, Author author, int year, int pageCount) {
        super(title, year, pageCount);
        this.isbn = isbn;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book: " + title + " by " + author + " (ISBN: " + isbn + ")";
    }

    public Author getAuthor() {
        return author;
    }

}
