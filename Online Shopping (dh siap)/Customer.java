import java.util.ArrayList;

public class Customer extends Akun {
    private Keranjang keranjang;
    private ArrayList<Invoice> history;

    public Customer(String id) {
        super(id); 
        this.keranjang = new Keranjang();
        this.history = new ArrayList<>();
    }

    public Customer(String id, String name, String password) {
        super(id, name, password); // Memanggil konstruktor dari kelas induk Akun
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
}
