import java.util.ArrayList;

public class Customer extends Akun {
    private Keranjang keranjang;
    private ArrayList<Invoice> history;

    // Konstruktor default (hanya menerima id)
    public Customer(String id) {
        super(id); // Memanggil konstruktor dari kelas induk Akun
        this.keranjang = new Keranjang();
        this.history = new ArrayList<>();
    }

    // Konstruktor dengan id, name, dan password
    public Customer(String id, String name, String password) {
        super(id, name, password); // Memanggil konstruktor dari kelas induk Akun
        this.keranjang = new Keranjang();
        this.history = new ArrayList<>();
    }

    // Getter untuk nama
    @Override
    public String getName() {
        return super.getName();  // Mengakses name dari kelas Akun
    }

    // Getter untuk keranjang
    public Keranjang getKeranjang() {
        return keranjang;
    }

    // Getter untuk riwayat transaksi
    public ArrayList<Invoice> getHistory() {
        return history;
    }

    // Menambahkan invoice ke riwayat transaksi
    public void addToHistory(Invoice invoice) {
        history.add(invoice);
    }
}
