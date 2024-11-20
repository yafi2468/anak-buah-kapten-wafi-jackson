import java.util.ArrayList;

public class Transaksi {
    private Customer customer;
    private ArrayList<Barang> items;

    public Transaksi(Customer customer) {
        if (customer.getKeranjang().isEmpty()) {
            throw new IllegalArgumentException("Cannot create transaction with an empty cart.");
        }
        this.customer = customer;
        this.items = new ArrayList<>(customer.getKeranjang().getItems());
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Barang> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction for Customer: ").append(customer.getId()).append("\nItems:\n");
        for (Barang item : items) {
            sb.append("- ").append(item).append("\n");
        }
        return sb.toString();
    }
}
