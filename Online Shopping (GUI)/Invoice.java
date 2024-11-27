import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Invoice {
    private Customer customer;
    private ArrayList<Barang> items; // Barang bukan String lagi
    private String paymentMethod;

    public Invoice(Transaksi var1) {
        this.customer = var1.getCustomer();
        this.items = var1.getItems(); // Mengambil daftar Barang
        this.paymentMethod = var1.getPaymentMethod();
    }

    public void displayInvoiceDetails() {
        StringBuilder var1 = new StringBuilder();
        var1.append("=== Invoice ===\n");
        var1.append("Pelanggan: ").append(this.customer.getName()).append("\n"); // Menampilkan nama pelanggan
        var1.append("Metode Pembayaran: ").append(this.paymentMethod).append("\n");
        var1.append("Daftar Barang:\n");

        double total = 0.0; // Variabel untuk menghitung total harga

        // Menampilkan setiap item dan harga
        for (Barang item : items) {
            var1.append("- ").append(item.getNama()).append(" : Rp").append(item.getHarga()).append("\n");
            total += item.getHarga(); // Menambahkan harga item ke total
        }

        var1.append("Total: Rp").append(total).append("\n"); // Menampilkan total harga
        JOptionPane.showMessageDialog((Component)null, var1.toString(), "Invoice", 1);
    }
}
