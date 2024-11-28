/* Ejemplo gestor de biblioteca */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LibraryManagerTest {

    private LibraryManager libraryManager;

    @BeforeEach
    public void setUp() {
        libraryManager = new LibraryManager();
    }

    @Test
    public void testAddBook() {
        libraryManager.addBook("1984", "George Orwell");
        assertEquals(1, libraryManager.getBooks().size());
    }

    @Test
    public void testSearchBooksByTitle() {
        libraryManager.addBook("1984", "George Orwell");
        libraryManager.addBook("Animal Farm", "George Orwell");
        List<Book> books = libraryManager.searchBooksByTitle("1984");
        assertEquals(1, books.size());
        assertEquals("1984", books.get(0).getTitle());
    }

    @Test
    public void testBorrowBook() {
        libraryManager.addBook("1984", "George Orwell");
        libraryManager.borrowBook("1984", "john_doe");
        assertEquals(1, libraryManager.getBorrowedBooks().size());
    }

    @Test
    public void testReturnBook() {
        libraryManager.addBook("1984", "George Orwell");
        libraryManager.borrowBook("1984", "john_doe");
        libraryManager.returnBook("1984", "john_doe");
        assertEquals(0, libraryManager.getBorrowedBooks().size());
    }

    @Test
    public void testGetBorrowedBooks() {
        libraryManager.addBook("1984", "George Orwell");
        libraryManager.addBook("Animal Farm", "George Orwell");
        libraryManager.borrowBook("1984", "john_doe");
        List<Book> borrowedBooks = libraryManager.getBorrowedBooks();
        assertEquals(1, borrowedBooks.size());
        assertEquals("1984", borrowedBooks.get(0).getTitle());
    }
}
