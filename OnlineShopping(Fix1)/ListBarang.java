import java.util.ArrayList;
import java.util.Scanner;

public class ListBarang {
    private ArrayList<Barang> items;

    public ListBarang() {
        this.items = new ArrayList<>();
    }

    public ArrayList<Barang> getBarang() {
        return items;
    }

    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("No items available!");
        } else {
            System.out.println("=== Available Items ===");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }
    }

    public void addItem(Scanner scanner) {
        System.out.print("Enter item name: ");
        scanner.nextLine(); // Consume leftover newline
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        items.add(new Barang(name, price));
        System.out.println("Item added successfully!");
    }

    public void editItem(Scanner scanner) {
        if (items.isEmpty()) {
            System.out.println("No items to edit.");
            return;
        }

        viewItems();
        System.out.print("Choose item number to edit: ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= items.size()) {
            System.out.println("Invalid choice!");
            return;
        }

        System.out.print("Enter new item name: ");
        scanner.nextLine(); // Consume leftover newline
        String newName = scanner.nextLine();
        System.out.print("Enter new item price: ");
        double newPrice = scanner.nextDouble();

        items.get(index).setNama(newName);
        items.get(index).setHarga(newPrice);
        System.out.println("Item updated successfully!");
    }

    public void deleteItem(Scanner scanner) {
        if (items.isEmpty()) {
            System.out.println("No items to delete.");
            return;
        }

        viewItems();
        System.out.print("Choose item number to delete: ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= items.size()) {
            System.out.println("Invalid choice!");
            return;
        }

        items.remove(index);
        System.out.println("Item deleted successfully!");
    }
}
