package BookManagement;

import java.util.List;

public class Library {
    String name;
    List<Book> books;
    List<LibraryUser> users;
    public Library(){};
    public Library(String name) {
        this.name = name;

    }

    public void addBook(Book book){
        this.books.add(book);
    }
    public void registerUser(LibraryUser user){
        users.add(user);
    }

    public Book findBook(String isbn){
        for (Book b:books){
            if(b.isbn.equals(isbn)){
                return b;
            }
        }
        return null;
    }

    public List<Book> getAvailableBooks(){
        return  books;
    }


}
