package BookManagement;

public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("J.K. Rowling", "British author best known for the Harry Potter series.");
        Author author2 = new Author("George Orwell", "English novelist and essayist, journalist and critic.");

        // Creating books
        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "978-0747532699", author1);
        Book book2 = new Book("1984", "978-0451524935", author2);

        // Creating library
        Library library = new Library("City Library");

        // Adding books to library
        library.addBook(book1);
        library.addBook(book2);

        // Creating library users
        LibraryUser user1 = new LibraryUser("Alice", "U001");
        LibraryUser user2 = new LibraryUser("Bob", "U002");

        library.registerUser(user1);
        library.registerUser(user2);
    }
}
