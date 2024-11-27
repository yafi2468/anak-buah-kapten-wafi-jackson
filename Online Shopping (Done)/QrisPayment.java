import javax.swing.*;

public class QrisPayment extends PaymentMethod {
    @Override
    public void processPayment() {
        System.out.println("=== QRIS Payment ===");
        System.out.println("Silahkan Scan QR Code untuk melanjutkan pembayaran.");

        // Menggunakan JDialog agar QR code muncul sebagai popup
        JDialog dialog = new JDialog();
        dialog.setTitle("QRIS Payment");
        dialog.setSize(1000, 1000);
        dialog.setLocationRelativeTo(null);  // Pusatkan jendela di layar
        dialog.setAlwaysOnTop(true);         // Jendela selalu di depan
        dialog.setModal(true);               // Membuat dialog menjadi modal (harus diselesaikan sebelum ke jendela lain)
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Menambahkan gambar QR ke JDialog
        JLabel qrLabel = new JLabel();
        ImageIcon qrImage = new ImageIcon("qris.png");  // Pastikan path gambar benar
        qrLabel.setIcon(qrImage);
        qrLabel.setHorizontalAlignment(SwingConstants.CENTER);

        dialog.add(qrLabel);
        dialog.setVisible(true);
    }
}
