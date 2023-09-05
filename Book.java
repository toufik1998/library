public class Book {
    private String title;
    private String author;
    private String isbn;
    private int quantity;

    public Book(String conTitle, String conAuthor, String conISBN, int conQuantity){
        title = conTitle;
        author = conAuthor;
        isbn = conISBN;
        quantity = conQuantity;
    }

    // Getters
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getISBN(){
        return isbn;
    }
    public int getQuantity(){
        return quantity;
    }

    // Setters
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    public void setAuthor(String newAuthor){
        this.author = newAuthor;
    }
    public void setISBN(String newISBN){
        this.isbn = newISBN;
    }
    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }

    public static void main(String[] args){
        Book newObj = new Book("my title", "my author", "my isbn", 55);
        System.out.println(newObj.author);
    }
}
