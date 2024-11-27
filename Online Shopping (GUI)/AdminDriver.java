import javax.swing.*; // Import untuk JOptionPane

public class AdminDriver {
    private Admin admin;          // Menyimpan referensi ke objek Admin
    private ListBarang listBarang;
    private ListTransaksi listTransaksi;

    // Modifikasi konstruktor untuk menerima Admin, ListBarang, dan ListTransaksi
    public AdminDriver(Admin admin, ListBarang listBarang, ListTransaksi listTransaksi) {
        this.admin = admin;          // Menyimpan admin
        this.listBarang = listBarang;  // Menyimpan listBarang
        this.listTransaksi = listTransaksi;  // Menyimpan listTransaksi
    }

    public void handleAdminMenu() {
        while (true) {
            String menu = """
                           === Admin Menu ===
                           1. Tambahkan Item
                           2. Tampilkan Item
                           3. Edit Item
                           4. Hapus Item
                           5. Tampilkan Transaksi
                           6. Logout
                           Pilih Opsi:""";
            String input = JOptionPane.showInputDialog(null, menu); // Menggunakan JOptionPane

            // Periksa apakah input adalah null (user menekan cancel) atau kosong
            if (input == null || input.trim().isEmpty()) {
                int option = JOptionPane.showConfirmDialog(null, "Apa kamu yakin ingin keluar?", "Konfirmasi keluar", JOptionPane.YES_NO_OPTION); // Menggunakan JOptionPane
                if (option == JOptionPane.YES_OPTION) {
                    return; // Keluar dari menu jika pengguna memilih YES
                } else {
                    continue; // Kembali ke menu jika pengguna memilih NO
                }
            }

            try {
                // Konversi input ke integer untuk menentukan pilihan menu
                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        listBarang.addItem(); // Menambah barang
                        break;
                    case 2:
                        listBarang.viewItems(); // Menampilkan daftar barang
                        break;
                    case 3:
                        listBarang.editItem(); // Mengedit barang
                        break;
                    case 4:
                        listBarang.deleteItem(); // Menghapus barang
                        break;
                    case 5:
                        listTransaksi.viewTransactions(); // Menampilkan transaksi
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Logging out..."); // Menggunakan JOptionPane
                        return; // Keluar dari menu admin jika logout
                    default:
                        JOptionPane.showMessageDialog(null, "Pilihan tidak valid! Mohon pilih Opsi yang benar."); // Menggunakan JOptionPane
                }
            } catch (NumberFormatException e) {
                // Menangani kesalahan jika input bukan angka
                JOptionPane.showMessageDialog(null, "Kredensial tidak valid!"); // Menggunakan JOptionPane
            }
        }
    }
}
