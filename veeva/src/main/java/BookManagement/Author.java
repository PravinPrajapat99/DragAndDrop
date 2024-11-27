package BookManagement;

import java.util.List;

public class Author {
    String name;
    String biography;
    List<Book> books;

    public Author(String name, String biography) {
        this.name = name;
        this.biography = biography;

    }


    public String  getAuthorDetails(){
        return this.name+" "+this.biography;
    }

    public void addBook(Book book){
        this.books.add(book);
    }



}
