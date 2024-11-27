import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QrisPayment extends PaymentMethod {
    @Override
    public void processPayment() {
        System.out.println("=== QRIS Payment ===");
        System.out.println("Silahkan Scan QR Code untuk melanjutkan pembayaran.");

        // Menggunakan JDialog agar QR code muncul sebagai popup
        JDialog dialog = new JDialog();
        dialog.setTitle("QRIS Payment");
        dialog.setSize(600, 650); // Menambahkan sedikit tinggi untuk tombol
        dialog.setLocationRelativeTo(null);  
        dialog.setAlwaysOnTop(true);        
        dialog.setModal(true);               
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Panel utama untuk menampung komponen
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Menambahkan gambar QR ke JDialog
        JLabel qrLabel = new JLabel();
        ImageIcon qrImage = new ImageIcon("qris.png"); // Pastikan path gambar benar
        qrLabel.setIcon(qrImage);
        qrLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(qrLabel, BorderLayout.CENTER);

        // Membuat tombol kembali
        JButton backButton = new JButton("Kembali");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Menutup dialog
            }
        });

        // Panel untuk tombol di bawah
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.add(mainPanel);
        dialog.setVisible(true);
    }
}
