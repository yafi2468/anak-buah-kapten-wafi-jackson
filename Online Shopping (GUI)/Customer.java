import java.util.ArrayList;
import javax.swing.*;

public class Customer extends Akun {
    private Keranjang keranjang;
    private ArrayList<Invoice> history;

    public Customer(String id) {
        super(id);
        this.keranjang = new Keranjang();
        this.history = new ArrayList<>();
    }

    public Customer(String id, String name, String password) {
        super(id, name, password);
        this.keranjang = new Keranjang();
        this.history = new ArrayList<>();
    }

    @Override
    public String getName() {
        return super.getName();
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

    public void displayCustomerInfo() {
        String info = "Customer ID: " + getId() + "\nName: " + getName();
        JOptionPane.showMessageDialog(null, info, "Customer Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
