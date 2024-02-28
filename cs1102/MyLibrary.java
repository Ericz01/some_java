import java.util.Scanner;

public class MyLibrary {
    private static final int MAX_BOOKS = 100; // Maximum number of books in the library
    private static String[] titles = new String[MAX_BOOKS];
    private static String[] authors = new String[MAX_BOOKS];
    private static int[] quantities = new int[MAX_BOOKS];
    private static int bookCount = 0; 

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Display menu and prompt user to select.
            System.out.println("\nLibrary System Menu:");
            System.out.println("A. Add Books");
            System.out.println("B. Borrow Books");
            System.out.println("R. Return Books");
            System.out.println("E. Exit");
            System.out.print("Select option (A, B, R or E): ");

            // Scan the choice entered and jump to the next line.
            char choice = Character.toUpperCase(scanner.next().charAt(0));;
            scanner.nextLine();

            // Work on the choice as entered.
            switch (choice) {
                case 'A':
                    addBooks();
                    break;
                case 'B':
                    borrowBooks();
                    break;
                case 'R':
                    returnBooks();
                    break;
                case 'E':
                    System.out.println("Thank you for using the library!");
                    return;
                // For an invalid choice
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add a book
    private static void addBooks() {

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        
        int index = findBook(title);
        if (index != -1) {
            // If the book already in the library
            quantities[index] += quantity;
            System.out.println("Quantity updated for existing book: " + title);
        } else {
            // If the book not in library
            titles[bookCount] = title;
            authors[bookCount] = author;
            quantities[bookCount] = quantity;
            bookCount++;
            System.out.println("New book added to library: " + title);
        }
    }
    // Borrow a book
    private static void borrowBooks() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of books to borrow: ");
        int quantity = scanner.nextInt();

        int index = findBook(title);
        if (index != -1) {
            // If enough copies are available
            if (quantities[index] >= quantity) {
                quantities[index] -= quantity;
                System.out.println("You have borrowed " + quantity + " copies of " + title);
            } else {
                System.out.println("Insufficient copies available for borrowing.");
            }
        } else {
            // If the book is not in the library
            System.out.println("Book not found in the library.");
        }
    }

    // Returning a borrowed book
    private static void returnBooks() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of books to return: ");
        int quantity = scanner.nextInt();

        int index = findBook(title);
        if (index != -1) {
            quantities[index] += quantity;
            System.out.println("You have returned " + quantity + " copies of " + title);
        } else {
            System.out.println("Book not found in the library.");
        }
    }
    // Books lookup.
    private static int findBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (titles[i].equalsIgnoreCase(title)) {
                return i;
            }
        }
        // If book not found
        return -1;
    }
}
