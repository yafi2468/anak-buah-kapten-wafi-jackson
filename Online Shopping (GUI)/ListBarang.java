import java.util.ArrayList;
import javax.swing.*;

public class ListBarang {
    private ArrayList<Barang> barangList; // Gunakan ArrayList<Barang>

    public ListBarang() {
        barangList = new ArrayList<>();
    }

    // Menambahkan item dengan objek Barang
    public void addItem() {
        boolean continueAdding = true;

        while (continueAdding) {
            String namaBarang = JOptionPane.showInputDialog("Masukkan nama item:");
            String hargaBarang = JOptionPane.showInputDialog("Masukkan harga item:");

            if (namaBarang != null && hargaBarang != null) {
                try {
                    double harga = Double.parseDouble(hargaBarang);
                    Barang barang = new Barang(namaBarang, harga); // Buat objek Barang
                    barangList.add(barang); // Tambahkan ke daftar
                    JOptionPane.showMessageDialog(null, "Item berhasil ditambahkan: " + barang);

                    // Tanyakan apakah ingin menambahkan item lain
                    int response = JOptionPane.showConfirmDialog(
                        null,
                        "Ingin menambahkan item lain?",
                        "Tambah Item",
                        JOptionPane.YES_NO_OPTION
                    );

                    if (response == JOptionPane.NO_OPTION) {
                        continueAdding = false; // Berhenti menambahkan
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Harga tidak valid. Silakan masukkan angka.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Input tidak boleh kosong.");
            }
        }
    }

    // Menampilkan semua barang dengan nomor urut
    public void viewItems() {
        if (barangList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tidak ada barang tersedia.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < barangList.size(); i++) {
            sb.append((i + 1)).append(". ").append(barangList.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // Mendapatkan item berdasarkan nomor urut
    public Barang getItemByIndex(int index) {
        if (index >= 0 && index < barangList.size()) {
            return barangList.get(index);
        }
        return null; // Jika index tidak valid
    }

    // Mendapatkan daftar barang (untuk Keranjang atau Transaksi)
    public ArrayList<Barang> getBarangList() {
        return barangList;
    }

    // Mengedit item berdasarkan nomor
    public void editItem() {
        viewItems(); // Tampilkan daftar barang
        String input = JOptionPane.showInputDialog("Masukkan nomor item yang ingin kamu edit:");

        if (input != null && !input.trim().isEmpty()) {
            try {
                int itemNumber = Integer.parseInt(input) - 1; // Konversi ke indeks array (0-based)

                if (itemNumber >= 0 && itemNumber < barangList.size()) {
                    String newName = JOptionPane.showInputDialog("Masukkan nama baru untuk item:");
                    String newPrice = JOptionPane.showInputDialog("Masukkan harga baru untuk item:");

                    if (newName != null && newPrice != null) {
                        try {
                            double price = Double.parseDouble(newPrice);
                            Barang barang = barangList.get(itemNumber);
                            barang.setNama(newName);
                            barang.setHarga(price);
                            JOptionPane.showMessageDialog(null, "Item berhasil diedit: " + barang);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Harga tidak valid.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nomor item tidak valid.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Input tidak valid.");
            }
        }
    }

    // Menghapus item berdasarkan nomor
    public void deleteItem() {
        viewItems();
        String input = JOptionPane.showInputDialog("Masukkan nomor item yang ingin dihapus:");

        if (input != null && !input.trim().isEmpty()) {
            try {
                int itemNumber = Integer.parseInt(input) - 1;

                if (itemNumber >= 0 && itemNumber < barangList.size()) {
                    Barang deletedItem = barangList.get(itemNumber);
                    barangList.remove(itemNumber);
                    JOptionPane.showMessageDialog(null, "Item berhasil dihapus: " + deletedItem);
                } else {
                    JOptionPane.showMessageDialog(null, "Nomor item tidak valid.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Input tidak valid.");
            }
        }
    }
}
