public class Invoice {
    private Transaksi transaksi;
    private String paymentMethod;

    // Konstruktor untuk menerima Transaksi dan paymentMethod
    public Invoice(Transaksi transaksi, String paymentMethod) {
        this.transaksi = transaksi;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Invoice ===\n");
        sb.append("Pelanggan: ").append(transaksi.getCustomer().getName()).append("\n");
        sb.append("Metode Pembayaran: ").append(paymentMethod).append("\n");
        sb.append("Daftar Barang:\n");

        // Menambahkan daftar barang yang dibeli
        for (Barang item : transaksi.getItems()) {
            sb.append("- ").append(item.getNama()).append(" : Rp").append(item.getHarga()).append("\n");
        }

        // Menambahkan total harga transaksi
        sb.append("Total: Rp").append(transaksi.calculateTotal()).append("\n");
        return sb.toString();
    }
}
