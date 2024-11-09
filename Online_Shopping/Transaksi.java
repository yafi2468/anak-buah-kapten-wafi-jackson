import java.util.ArrayList;

public class Transaksi {
    private Customer akun;
    private ArrayList<Barang> barang;

    public Transaksi() {
        this.barang = new ArrayList<>();
    }

    public Customer getAkun() {
        return akun;
    }

    public void setAkun(Customer akun) {
        this.akun = akun;
    }

    public ArrayList<Barang> getBarang() {
        return barang;
    }

    public void addBarang(Barang b) {
        barang.add(b);
    }
}