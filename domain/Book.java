package domain;

import repository.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Book {
    private String title;
    private int idAuthor;
    private String isbn;
    private int quantity;
    private List<BookCopy> copies;

    public Book(String title , int author, String isbn, int quantity){
        this.title = title;
        this.idAuthor = author;
        this.isbn = isbn;
        this.quantity = quantity;
    }
    
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public int getAuthor(){ return idAuthor; }
    public void setAuthor(int author){
        this.idAuthor = author;
    }

    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public List<BookCopy> getCopies() {
        return copies;
    }

    public void setCopies(List<BookCopy> copies) {
        this.copies = copies;
    }

}
