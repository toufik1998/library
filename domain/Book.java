package domain;

import java.util.List;

public class Book {
    private String title;
    private Author author;
    private String isbn;
    private int quantity;
    private List<BookCopy> copies;

    public Book(String title , Author author, String isbn, int quantity){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
    }
    
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public Author getAuthor(){
        return author;
    }
    public void setAuthor(Author author){
        this.author = author;
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



//    public static void main(String[] args)
//    {
//
//        Book newObj = new Book("Crime and Punishment\n", "Fyodor Dostoevsky", "0-9767736-6-X", 10);
//        System.out.println("************************************");
//        System.out.println("Title :".concat(" ").concat(newObj.getTitle()));
//        System.out.println("Author :".concat(" ").concat(newObj.getAuthor()));
//        System.out.println("ISBN :".concat(" ").concat(newObj.getISBN()));
//        System.out.println("Quantity : " + newObj.getQuantity());
//        System.out.println("************************************");
//    }
}
