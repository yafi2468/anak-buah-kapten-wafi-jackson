import java.util.ArrayList;

public class Customer extends Akun {
    private Keranjang keranjang;
    private ArrayList<Invoice> history;

    public Customer(String id) {
        super(id);
        this.keranjang = new Keranjang();
        this.history = new ArrayList<>();
    }

    public Keranjang getKeranjang() {
        return keranjang;
    }

    public ArrayList<Invoice> getHistory() {
        return history;
    }

    public void addToHistory(Invoice invoice) {
        history.add(invoice);
    }
}
