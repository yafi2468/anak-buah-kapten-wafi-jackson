public class Invoice {
    private Transaksi transaksi;
    private Pembayaran pembayaran;

    public Invoice(Transaksi transaksi, Pembayaran pembayaran) {
        this.transaksi = transaksi;
        this.pembayaran = pembayaran;
    }

    @Override
    public String toString() {
        return "Invoice:\n" +
               transaksi + "\n" +
               "Payment Method: " + pembayaran.getClass().getSimpleName() + "\n" +
               "Details: " + pembayaran.getDetails();
    }
}
