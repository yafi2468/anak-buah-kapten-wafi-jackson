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
            System.out.println("1. Tampilkan Item Tersedia");
            System.out.println("2. Tambahkan Item Ke Keranjang");
            System.out.println("3. Tampilkan Keranjang");
            System.out.println("4. Checkout");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("6. Logout");
            System.out.print("Pilih Opsi: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: 
                viewAvailableItems();
                break;
                case 2: 
                addItemToCart(scanner);
                break;
                case 3: viewCart();
                break;
                case 4: checkout(scanner);
                break;
                case 5: viewTransactionHistory();
                break;
                case 6 : 
                running = false;
                System.out.println("Logging out...");
                break;

                default: System.out.println("Pilihan tidak Valid! Silahkan coba lagi");
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
            System.out.println("Keranjang Kosong! Tambahkan Barang Sebelum Checkout.");
            return;
        }

        System.out.println("\n=== Metode Pembayaran ===");
        System.out.println("1. QRIS");
        System.out.println("2. Transfer Bank");
        System.out.println("3. Cash On Delivery");
        System.out.print("Pilih Metode Pembayaran: ");
        int paymentChoice = scanner.nextInt();

        PaymentMethod paymentMethod;
        switch (paymentChoice) {
            case 1:
            paymentMethod = new QrisPayment();
            break;
            case 2: 
            paymentMethod = new BankTransferPayment();
            break;
            case 3: 
            paymentMethod = new CashOnDeliveryPayment();
            break;
            default: {
                System.out.println("Pilihan tidak valid! Default ke Cash On Delivery.");
                paymentMethod = new CashOnDeliveryPayment();
            }
        }

        paymentMethod.processPayment();
        Transaksi transaksi = new Transaksi(customer, paymentMethod.getClass().getSimpleName());
        listTransaksi.addTransaction(transaksi);

        keranjang.clearCart();
        System.out.println("Checkout Berhasil! Terima kasih telah berbelanja.");
    }

    private void viewTransactionHistory() {
        listTransaksi.viewTransactions();
    }
}
