package domain;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String first_name;
    private String last_name;
    private List<Book> books;

    public Author(String first_name, String last_name)
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.books = new ArrayList<>();
    }

    public String getFirst_name(){
        return first_name;
    }
    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public String getLast_name(){
        return last_name;
    }
    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public List<Book> getBooks(){
        return books;
    }
    public void setBooks(List<Book> books){
        this.books = books;
    }
}
