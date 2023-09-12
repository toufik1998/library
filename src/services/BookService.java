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

    public void addBook(Book book) throws SQLException {
        int authorId = bookRepository.getAuthorId(book.getAuthor());
        boolean isTitleValid = !book.getTitle().isEmpty() && book.getTitle().length() <= 100;
        boolean isISBNValid = book.getIsbn().matches("[0-9]-.*");
        boolean isQuantityValid = book.getQuantity() > 0;

        if(authorId > 0){
            if(isTitleValid && isISBNValid && isQuantityValid){
                bookRepository.addBook(book, authorId);
            }
        }else {
            System.out.println("No author has the name " + book.getAuthor());
        }

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
