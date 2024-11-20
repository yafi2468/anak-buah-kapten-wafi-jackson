import java.util.ArrayList;
import java.util.Scanner;

public class Keranjang {
    private ArrayList<Barang> items;

    public Keranjang() {
        this.items = new ArrayList<>();
    }

    public ArrayList<Barang> getItems() {
        return items;
    }

    public void addItem(Scanner scanner, ListBarang listBarang) {
        if (listBarang.getBarang().isEmpty()) {
            System.out.println("No items available to add.");
            return;
        }

        listBarang.viewItems();
        System.out.print("Choose an item number to add to the cart: ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= listBarang.getBarang().size()) {
            System.out.println("Invalid choice!");
            return;
        }

        items.add(listBarang.getBarang().get(index));
        System.out.println("Item added to cart!");
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("=== Your Cart ===");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clearCart() {
        items.clear();
    }
}
