package repository;

import domain.Book;
import jdk.jshell.spi.SPIResolutionException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private DbConnection dbConnection;

    public BookRepository(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addBook(Book book) throws SQLException{
        String query = "INSERT INTO book (title, author_id, isbn, quantity) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);
        statement.setString(1, book.getTitle());
        statement.setInt(2, book.getAuthor());
        statement.setString(3, book.getIsbn());
        statement.setInt(4, book.getQuantity());

        statement.executeUpdate();
    };

    public boolean isBookExists(String isbn) throws SQLException {
        String query = "SELECT * FROM book WHERE isbn = ?";

        PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);
        statement.setString(1, isbn);
        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? true : false;
    }


    public void updateBook(String isbn, Book updateBook) throws SQLException{
        String query = "UPDATE book SET title = ? , author_id = ? , quantity = ? WHERE isbn = ?";

        PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);
        statement.setString(1, updateBook.getTitle());
        statement.setInt(2, updateBook.getAuthor());
        statement.setInt(3, updateBook.getQuantity());
        statement.setString(4, updateBook.getIsbn());
        statement.executeUpdate();
    }

    public void deleteBook(String isbn) throws SQLException{
        String query = "DELETE FROM book WHERE isbn = ?";

        PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);
        statement.setString(1, isbn);
        statement.executeUpdate();
    }

    public List<Book> getAllAvailableBooks() throws SQLException{
        List<Book> availableBooks = new ArrayList<>();

        String query = "SELECT book.id, book.title, book.author_id, book.isbn, book.quantity FROM book WHERE isbn IN (SELECT DISTINCT(book.isbn) FROM book INNER JOIN bookcopy ON book.id = bookcopy.book_id WHERE bookcopy.status = 'available')";
        PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            String title = resultSet.getString("title");
            int authorId = resultSet.getInt("author_id");
            String isbn = resultSet.getString("isbn");
            int quantity = resultSet.getInt("quantity");

            Book book = new Book(title, authorId, isbn, quantity);

            availableBooks.add(book);
        }
        return  availableBooks;

    }


    public List<Book> searchBook(String title) throws SQLException {
        List<Book> foundedBooks = new ArrayList<>();

        String query = "SELECT * FROM book WHERE title LIKE ?";

        PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);
        statement.setString(1, "%" + title + "%");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String bookTitle = resultSet.getString("title");
            int bookAuthorId = resultSet.getInt("author_id");
            String bookISBN = resultSet.getString("isbn");
            int bookQuantity = resultSet.getInt("quantity");

            Book book = new Book(bookTitle, bookAuthorId, bookISBN, bookQuantity);

            foundedBooks.add(book);
        }
        return foundedBooks;
    }
}