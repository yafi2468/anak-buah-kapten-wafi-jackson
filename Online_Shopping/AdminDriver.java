import java.util.ArrayList;

public class AdminDriver extends Driver {
    private Admin akun;
    private ListBarang listBarang;
    private ArrayList<Transaksi> listTransaksi;

    public AdminDriver(Admin akun) {
        this.akun = akun;
        this.listBarang = new ListBarang();
        this.listTransaksi = new ArrayList<>();
    }

    public Admin getAkun() {
        return akun;
    }

    public ListBarang getListBarang() {
        return listBarang;
    }

    public ArrayList<Transaksi> getListTransaksi() {
        return listTransaksi;
    }
}
