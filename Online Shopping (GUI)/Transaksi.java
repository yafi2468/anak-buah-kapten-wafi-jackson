import javax.swing.*;
import java.util.ArrayList;

public class Transaksi {
    private Customer customer;
    private ArrayList<Barang> items; // Menggunakan Barang, bukan hanya String
    private String paymentMethod;

    public Transaksi(Customer customer, String paymentMethod) {
        if (customer.getKeranjang().isCartEmpty()) {
            throw new IllegalArgumentException("Tidak dapat melakukan transaksi apabila keranjang kosong.");
        }
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.items = new ArrayList<>(customer.getKeranjang().getItems()); // Mengambil daftar Barang dari Keranjang
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Barang> getItems() {
        return items;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Menampilkan transaksi dalam format string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaksi untuk customer: ").append(customer.getName()).append("\n");
        sb.append("Items:\n");
        
        double totalPrice = 0.0;  // Variabel untuk menghitung total harga

        for (Barang item : items) {
            sb.append("- ").append(item.toString()).append("\n"); // Menampilkan informasi lengkap barang
            totalPrice += item.getHarga();  // Menambahkan harga item ke total
        }

        sb.append("Metode pembayaran: ").append(paymentMethod).append("\n");
        sb.append("Total Harga: Rp").append(totalPrice).append("\n");  // Menampilkan total harga

        return sb.toString();
    }

    public void displayTransactionDetails() {
        JOptionPane.showMessageDialog(null, this.toString(), "Detail Transaksi", JOptionPane.INFORMATION_MESSAGE);
    }
}
