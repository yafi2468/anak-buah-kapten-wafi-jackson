
import javax.swing.JOptionPane;

public class BankTransferPayment extends PaymentMethod {
    private final String bankAccountNumber = "123-456-789";

    public BankTransferPayment() {
        super("Bank Transfer");
    }

    @Override
    public void processPayment() {
        JOptionPane.showMessageDialog(null, "Silahkan transfer ke nomor rekening berikut untuk melanjutkan pembayaran:\nBank: Bank Sejahtera\nNomor Rekening: " + bankAccountNumber);
    }
}
