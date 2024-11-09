public class Invoice {
    private Transaksi transaksi;
    private Pembayaran pembayaran;

    public Invoice(Transaksi transaksi, Pembayaran pembayaran) {
        this.transaksi = transaksi;
        this.pembayaran = pembayaran;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }
}