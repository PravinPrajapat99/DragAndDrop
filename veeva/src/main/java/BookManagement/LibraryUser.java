package BookManagement;

import java.util.List;

public class LibraryUser {
    String name;
    String userId;
    List<Book> borrowedBook;

    public LibraryUser(){};

    public LibraryUser(String name, String userId) {
        this.name = name;
        this.userId = userId;

    }

    public void borrowBook(Book book){
        this.borrowedBook.add(book);
    }

    public  void  returnBook(Book book){
        borrowedBook.remove(book);
    }



}
