public class BankTransferPayment extends PaymentMethod {
    private final String bankAccountNumber = "123-456-789";

    @Override
    public void processPayment() {
        System.out.println("=== Transfer Bank Payment ===");
        System.out.println("Silahkan transfer ke nomor rekening berikut untuk melanjutkan pembayaran:");
        System.out.println("Bank: Bank Sejahtera");
        System.out.println("Nomor Rekening: " + bankAccountNumber);
    }
}
