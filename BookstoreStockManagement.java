import java.util.HashMap;
import java.util.Scanner;

public class BookstoreStockManagement {
    private HashMap<String, Integer> stock;

    public BookstoreStockManagement() {
        stock = new HashMap<>();
    }

    // Add a new publication
    public void addPublication(String title, int quantity) {
        if (stock.containsKey(title)) {
            System.out.println("Publication already exists. Use updateQuantity to change the quantity.");
        } else {
            stock.put(title, quantity);
            System.out.println("Publication added: " + title + " with quantity " + quantity);
        }
    }

    // Update the quantity of an existing publication
    public void updateQuantity(String title, int quantity) {
        if (stock.containsKey(title)) {
            stock.put(title, stock.get(title) + quantity);
            System.out.println("Updated quantity for " + title + " to " + stock.get(title));
        } else {
            System.out.println("Publication does not exist. Use addPublication to add it first.");
        }
    }

    // Search for a publication by its title
    public void searchPublication(String title) {
        if (stock.containsKey(title)) {
            System.out.println("Found " + title + " with quantity " + stock.get(title));
        } else {
            System.out.println("Publication not found.");
        }
    }

    public static void main(String[] args) {
        BookstoreStockManagement bookstore = new BookstoreStockManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: 1. Add Publication 2. Update Quantity 3. Search Publication 4. Exit");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 4) break;

            System.out.println("Enter title:");
            String title = scanner.nextLine();

            if (option == 1) {
                System.out.println("Enter quantity:");
                int quantity = scanner.nextInt();
                bookstore.addPublication(title, quantity);
            } else if (option == 2) {
                System.out.println("Enter quantity to add:");
                int quantity = scanner.nextInt();
                bookstore.updateQuantity(title, quantity);
            } else if (option == 3) {
                bookstore.searchPublication(title);
            }
        }

        scanner.close();
    }
}
