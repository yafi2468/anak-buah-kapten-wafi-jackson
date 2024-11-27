import java.util.ArrayList;

public class Transaksi {
    private Customer customer;
    private ArrayList<Barang> items;
    private String paymentMethod;

    // Konstruktor yang sesuai
    public Transaksi(Customer customer, String paymentMethod, ArrayList<Barang> items) {
        if (items.isEmpty()) {
            throw new IllegalArgumentException("Cannot create transaction with an empty cart.");
        }
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.items = items;
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

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Menghitung total harga dari transaksi
    public double calculateTotal() {
        double total = 0;
        for (Barang item : items) {
            total += item.getHarga();  // Menggunakan metode getHarga() dari kelas Barang
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaksi Oleh Pelanggan: ").append(customer.getId()).append("\n");
        sb.append("Items:\n");
        for (Barang item : items) {
            sb.append("- ").append(item).append(" : Rp").append(item.getHarga()).append("\n");
        }
        sb.append("Metode pembayaran: ").append(paymentMethod).append("\n");
        sb.append("Total: Rp").append(calculateTotal()).append("\n"); // Menambahkan total transaksi
        return sb.toString();
    }
}
