public abstract class PaymentMethod {
    private String paymentMethod;

    public PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Method untuk memproses pembayaran (abstrak, harus diimplementasikan di subclass)
    public abstract void processPayment();

    // Menambahkan metode getPaymentType() untuk mengembalikan tipe pembayaran
    public String getPaymentType() {
        return paymentMethod;
    }
}
