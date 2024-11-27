package BookManagement;

public class Book {
    String title;
    String isbn;
    Author author;
    boolean isAvailable;

    public Book(String title, String isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;

    }

    public String getDetails(){
        return this.title+" "+this.isbn+" "+this.author+" "+this.title;
    }



}
