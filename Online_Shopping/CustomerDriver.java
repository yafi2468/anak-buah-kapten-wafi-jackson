public class CustomerDriver extends Driver {
    private Customer akun;
    private Transaksi transaksi;
    private ListBarang barang;

    public CustomerDriver(Customer akun) {
        this.akun = akun;
        this.transaksi = new Transaksi();
        this.barang = new ListBarang();
    }

    public Customer getAkun() {
        return akun;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public ListBarang getBarang() {
        return barang;
    }
}
