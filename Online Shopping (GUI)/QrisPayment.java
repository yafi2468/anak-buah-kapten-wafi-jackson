import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QrisPayment extends PaymentMethod {

    // Konstruktor (panggil konstruktor kelas induk jika diperlukan)
    public QrisPayment() {
        super("QRIS"); // Pastikan konstruktor kelas induk menerima "QRIS"
    }

    @Override
    public void processPayment() {
        // Frame utama
        JFrame frame = new JFrame("QRIS Payment");
        frame.setSize(600, 700); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Label informasi
        JLabel infoLabel = new JLabel("<html><h3>Silahkan Scan QR Code untuk melanjutkan pembayaran.</h3></html>", SwingConstants.CENTER);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(infoLabel, BorderLayout.NORTH);

        // Panel untuk menggambar QR code
        JPanel qrPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon qrImage = new ImageIcon("qris.png");
                Image scaledImage = qrImage.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                g.drawImage(scaledImage, (getWidth() - 300) / 2, (getHeight() - 300) / 2, null); // Pusatkan gambar
            }
        };
        qrPanel.setPreferredSize(new Dimension(400, 400)); // Ukuran tetap panel
        frame.add(qrPanel, BorderLayout.CENTER);

        // Tombol kembali
        JButton backButton = new JButton("Kembali");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Menutup frame
            }
        });

        // Panel tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Menampilkan frame
        frame.setVisible(true);
    }
}
