
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book class to represent digital resources
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean status) { this.isAvailable = status; }

    @Override
    public String toString() {
        return String.format("ID: %d | Title: %-20s | Author: %-15s | Available: %s", 
                              id, title, author, isAvailable ? "Yes" : "No");
    }
}

// Library Management System logic
public class DigitalLibrary {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void showAllBooks() {
        System.out.println("\n--- Library Catalog ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void borrowBook(int id) {
        for (Book b : books) {
            if (b.getId() == id && b.isAvailable()) {
                b.setAvailable(false);
                System.out.println("Success! You have borrowed: " + b.getTitle());
                return;
            }
        }
        System.out.println("Error: Book not found or already borrowed.");
    }

    public static void main(String[] args) {
        DigitalLibrary lib = new DigitalLibrary();
        Scanner scanner = new Scanner(System.in);
        
        // Pre-loading some digital books
        lib.addBook(new Book(101, "Java Programming", "James Gosling"));
        lib.addBook(new Book(102, "Clean Code", "Robert Martin"));
        lib.addBook(new Book(103, "Effective Java", "Joshua Bloch"));

        while (true) {
            System.out.println("\nDigital Library Menu:");
            System.out.println("1. View Books\n2. Borrow Book\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                lib.showAllBooks();
            } else if (choice == 2) {
                System.out.print("Enter Book ID to borrow: ");
                int id = scanner.nextInt();
                lib.borrowBook(id);
            } else if (choice == 3) {
                System.out.println("Exiting System. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}