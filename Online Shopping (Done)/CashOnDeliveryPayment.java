public class CashOnDeliveryPayment extends PaymentMethod {
    @Override
    public void processPayment() {
        System.out.println("=== Cash On Delivery (COD) Payment ===");
        System.out.println("Bayar ketika barang diterima di lokasi pengiriman.");
    }
}
