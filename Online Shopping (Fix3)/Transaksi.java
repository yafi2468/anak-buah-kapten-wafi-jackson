import java.util.ArrayList;

public class Transaksi {
    private Customer customer;
    private ArrayList<Barang> items;
    private String paymentMethod; // Tambahan untuk metode pembayaran

    // Constructor
    public Transaksi(Customer customer, String paymentMethod) {
        if (customer.getKeranjang().isEmpty()) {
            throw new IllegalArgumentException("Cannot create transaction with an empty cart.");
        }
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.items = new ArrayList<>(customer.getKeranjang().getItems());
    }

    // Getter untuk Customer
    public Customer getCustomer() {
        return customer;
    }

    // Getter untuk Items
    public ArrayList<Barang> getItems() {
        return items;
    }

    // Getter dan Setter untuk Payment Method
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction for Customer: ").append(customer.getId()).append("\n");
        sb.append("Items:\n");
        for (Barang item : items) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("Payment Method: ").append(paymentMethod).append("\n");
        return sb.toString();
    }
}
