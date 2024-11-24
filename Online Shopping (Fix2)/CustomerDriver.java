import java.util.Scanner;

public class CustomerDriver {
    private Customer customer;
    private ListBarang listBarang; // Shared ListBarang
    private ListTransaksi listTransaksi; // Shared ListTransaksi

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
        listBarang.viewItems(); // Menggunakan instance ListBarang yang sama
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

        // Menampilkan metode pembayaran yang tersedia
        System.out.println("\n=== Payment Method ===");
        System.out.println("1. QRIS");
        System.out.println("2. Transfer Bank");
        System.out.println("3. Cash On Delivery");
        System.out.print("Choose a payment method: ");
        int paymentChoice = scanner.nextInt();
    
        String paymentMethod;
        Pembayaran pembayaran = null;  // Inisialisasi variabel pembayaran

        switch (paymentChoice) {
            case 1:
                paymentMethod = "QRIS";
                pembayaran = new QRIS(); // Membuat objek pembayaran untuk QRIS
                System.out.println("You selected QRIS. Please scan the QR code to proceed.");
                break;
            case 2:
                paymentMethod = "Transfer Bank";
                pembayaran = new TransferBank(); // Membuat objek pembayaran untuk Transfer Bank
                System.out.println("You selected Transfer Bank. Bank details will be provided.");
                break;
            case 3:
                paymentMethod = "Cash On Delivery";
                pembayaran = new CashOnDelivery(); // Membuat objek pembayaran untuk Cash On Delivery
                System.out.println("You selected Cash On Delivery. Pay when you receive the item.");
                break;
            default:
                System.out.println("Invalid choice! Defaulting to Cash On Delivery.");
                paymentMethod = "Cash On Delivery";
                pembayaran = new CashOnDelivery(); // Default ke Cash On Delivery
        }
    
        // Membuat transaksi
        Transaksi transaksi = new Transaksi(customer, paymentMethod);
        listTransaksi.addTransaction(transaksi);
    
        // Membuat dan menampilkan Invoice
        Invoice invoice = new Invoice(transaksi, pembayaran);
        System.out.println("\n" + invoice);

        // Mengosongkan keranjang setelah checkout
        keranjang.clearCart();
        System.out.println("Checkout successful! Payment method: " + paymentMethod);
    }

    private void viewTransactionHistory() {
        listTransaksi.viewTransactions(); // Menggunakan instance ListTransaksi yang sama
    }
}
