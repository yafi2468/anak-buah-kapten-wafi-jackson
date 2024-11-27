import javax.swing.JOptionPane;

public class CustomerDriver {
    private final Customer customer;
    private final ListBarang listBarang;
    private final ListTransaksi listTransaksi;

    public CustomerDriver(Customer customer, ListBarang listBarang, ListTransaksi listTransaksi) {
        this.customer = customer;
        this.listBarang = listBarang;
        this.listTransaksi = listTransaksi;
    }

    public void start() {
        boolean running = true;
        while (running) {
            String menu = """
                          
                          === Customer Menu ===
                          1. Tampilkan Item yang Tersedia
                          2. Tambahkan Item ke Keranjang
                          3. Tampilkan Keranjang
                          4. Checkout
                          5. Tampilkan Riwayat Transaksi
                          6. Logout
                          Pilih Opsi:""";
            String input = JOptionPane.showInputDialog(null, menu);
            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1 -> viewAvailableItems();
                case 2 -> addItemToCart();
                case 3 -> viewCart();
                case 4 -> checkout();
                case 5 -> viewTransactionHistory();
                case 6 -> {
                    running = false;
                    JOptionPane.showMessageDialog(null, "Logging out...");
                }
                default -> JOptionPane.showMessageDialog(null, "Pilihan tidak valid! Silakan coba lagi.");
            }
        }
    }

    private void viewAvailableItems() {
        listBarang.viewItems();
    }

    private void addItemToCart() {
        listBarang.viewItems(); // Tampilkan semua barang yang tersedia

        String input = JOptionPane.showInputDialog("Masukkan nomor item yang ingin ditambahkan ke keranjang:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int itemNumber = Integer.parseInt(input) - 1;

                // Periksa apakah index yang dimasukkan valid
                if (itemNumber >= 0 && itemNumber < listBarang.getBarangList().size()) {
                    // Dapatkan objek Barang, bukan String
                    Barang item = listBarang.getItemByIndex(itemNumber); // Mengambil objek Barang
                    if (item != null) {
                        // Menambahkan objek Barang ke keranjang
                        customer.getKeranjang().addItemToCart(item);
                        JOptionPane.showMessageDialog(null, "Item berhasil ditambahkan ke keranjang: " + item.getNama());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nomor item tidak valid.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Kredensial tidak valid.");
            }
        }
    }

    private void viewCart() {
        customer.getKeranjang().viewCart();
    }

    private void checkout() {
        if (customer.getKeranjang().isCartEmpty()) {
            JOptionPane.showMessageDialog(null, "Keranjangmu masih kosong. Tambahkan item dulu sebelum checkout.");
            return;
        }

        String paymentMethodMenu = """
                                    === Metode Pembayaran ===
                                    1. Cash On Delivery
                                    2. QRIS
                                    3. Bank Transfer
                                    Pilih metode pembayaran:""";
        String input = JOptionPane.showInputDialog(null, paymentMethodMenu);
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Metode pembayaran dibatalkan.");
            return;
        }

        try {
            int choice = Integer.parseInt(input);
            PaymentMethod paymentMethod;

            switch (choice) {
                case 1 -> paymentMethod = new CashOnDeliveryPayment();
                case 2 -> paymentMethod = new QrisPayment();
                case 3 -> paymentMethod = new BankTransferPayment();
                default -> throw new IllegalArgumentException("Metode pembayaran tidak valid!");
            }

            paymentMethod.processPayment(); // Proses pembayaran
            addTransaction(paymentMethod.getPaymentType()); // Menambahkan transaksi ke daftar

            // Setelah transaksi selesai, langsung tampilkan invoice
            displayInvoice();

            // Mengosongkan keranjang setelah checkout
            customer.getKeranjang().clearCart(); // Mengosongkan keranjang setelah checkout
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Kredensial tidak valid.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void addTransaction(String paymentMethod) {
        try {
            Transaksi transaksi = new Transaksi(customer, paymentMethod);
            listTransaksi.addTransaction(transaksi);  // Menambahkan transaksi ke listTransaksi
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private void displayInvoice() {
        // Membuat invoice berdasarkan transaksi terakhir
        Transaksi transaksi = listTransaksi.getLatestTransaction();  // Ambil transaksi terakhir
        if (transaksi != null) {
            // Invoice membutuhkan transaksi untuk ditampilkan
            Invoice invoice = new Invoice(transaksi); 
            invoice.displayInvoiceDetails();  // Menampilkan invoice dengan detail transaksi
        } else {
            JOptionPane.showMessageDialog(null, "Tidak ada transaksi yang ditemukan.");
        }
    }

    private void viewTransactionHistory() {
        listTransaksi.viewTransactions();
    }
}
