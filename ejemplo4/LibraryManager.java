import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManager {

    private List<Book> books = new ArrayList<>();
    private Map<String, String> borrowedBooks = new HashMap<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    public List<Book> searchBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public void borrowBook(String title, String username) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !borrowedBooks.containsKey(title)) {
                borrowedBooks.put(title, username);
                break;
            }
        }
    }

    public void returnBook(String title, String username) {
        if (borrowedBooks.containsKey(title) && borrowedBooks.get(title).equals(username)) {
            borrowedBooks.remove(title);
        }
    }

    public List<Book> getBorrowedBooks() {
        List<Book> result = new ArrayList<>();
        for (String title : borrowedBooks.keySet()) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    result.add(book);
                }
            }
        }
        return result;
    }
}
