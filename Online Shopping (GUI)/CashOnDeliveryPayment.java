
import javax.swing.JOptionPane;

public class CashOnDeliveryPayment extends PaymentMethod {
    public CashOnDeliveryPayment() {
        super("Cash On Delivery");
    }

    @Override
    public void processPayment() {
        JOptionPane.showMessageDialog(null, "Bayar ketika barang diterima di lokasi pengiriman.");
    }
}
