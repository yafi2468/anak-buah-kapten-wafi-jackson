import java.util.ArrayList;

public class ListBarang {
    private ArrayList<Barang> barang;

    public ListBarang() {
        this.barang = new ArrayList<>();
    }

    public ArrayList<Barang> getBarang() {
        return barang;
    }

    public void addBarang(Barang b) {
        barang.add(b);
    }
}
