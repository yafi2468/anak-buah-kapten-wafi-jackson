import java.util.ArrayList;

public class Keranjang {
    private ArrayList<Barang> barang;

    public Keranjang() {
        this.barang = new ArrayList<>();
    }

    public ArrayList<Barang> getBarang() {
        return barang;
    }

    public void addBarang(Barang b) {
        barang.add(b);
    }
}
