package services;

import domain.Book;
import repository.BookRepository;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) throws SQLException{
            bookRepository.addBook(book);
            System.out.println("Book added successfully.");
    }

    public boolean isBookExists(String isbn) throws SQLException{
        return bookRepository.isBookExists(isbn);
    }



    public void updateBook(String isbn, Book updateBook) throws SQLException{
        bookRepository.updateBook(isbn, updateBook);
    }

    public void deleteBook(String isbn) throws SQLException{
        bookRepository.deleteBook(isbn);
    }

    public List<Book> getAllAvailableBooks() throws SQLException {
        return bookRepository.getAllAvailableBooks();
    }

    public List<Book> searchBook(String title) throws SQLException{
        return bookRepository.searchBook(title);
    }

}
