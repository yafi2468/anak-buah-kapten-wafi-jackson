import java.util.Scanner;

public class CustomerDriver {
    private Customer customer;
    private ListBarang listBarang;
    private ListTransaksi listTransaksi;

    public CustomerDriver(Customer customer, ListBarang listBarang, ListTransaksi listTransaksi) {
        this.customer = customer;
        this.listBarang = listBarang;
        this.listTransaksi = listTransaksi;
    }

    public void start(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. View Available Items");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. View Transaction History");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableItems();
                    break;
                case 2:
                    addItemToCart(scanner);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    checkout(scanner);
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 6:
                    running = false;
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void viewAvailableItems() {
        listBarang.viewItems();
    }

    private void addItemToCart(Scanner scanner) {
        customer.getKeranjang().addItem(scanner, listBarang);
    }

    private void viewCart() {
        customer.getKeranjang().viewCart();
    }

    private void checkout(Scanner scanner) {
        Keranjang keranjang = customer.getKeranjang();

        if (keranjang.isEmpty()) {
            System.out.println("Your cart is empty! Add items before checking out.");
            return;
        }

        keranjangcheckout(scanner);

        // Create a transaction and add it to the transaction history
        Transaksi transaksi = new Transaksi(customer);
        listTransaksi.addTransaction(transaksi);

        // Clear the customer's cart
        keranjang.clearCart();
    }

    private void viewTransactionHistory() {
        listTransaksi.viewTransactions();
    }
}
