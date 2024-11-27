import java.util.ArrayList;

public class Transaksi {
    private Customer customer;
    private ArrayList<Barang> items;
    private String paymentMethod; 

    public Transaksi(Customer customer, String paymentMethod) {
        if (customer.getKeranjang().isEmpty()) {
            throw new IllegalArgumentException("Cannot create transaction with an empty cart.");
        }
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.items = new ArrayList<>(customer.getKeranjang().getItems());
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction for Customer: ").append(customer.getId()).append("\n");
        sb.append("Items:\n");
        for (Barang item : items) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("Metode pembayaran: ").append(paymentMethod).append("\n");
        return sb.toString();
    }
}
