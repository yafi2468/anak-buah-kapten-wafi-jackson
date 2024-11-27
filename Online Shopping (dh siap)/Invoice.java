public class Invoice {
    private Transaksi transaksi;
    private String paymentMethod;

    public Invoice(Transaksi transaksi, String paymentMethod) {
        this.transaksi = transaksi;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice:\n");
        sb.append(transaksi).append("\n");
        sb.append("Metode Pembayaran: ").append(paymentMethod).append("\n");
        return sb.toString();
    }
}
