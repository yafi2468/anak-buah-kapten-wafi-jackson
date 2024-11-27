import javax.swing.*;

public class Barang {
    private String nama;
    private double harga;

    public Barang(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Item: " + nama + " - Rp" + harga;  // Format lebih konsisten dengan format di ListBarang
    }

    public void displayItemDetails() {
        String details = "Item: " + nama + "\nHarga: " + harga;
        JOptionPane.showMessageDialog(null, details, "Item Details", JOptionPane.INFORMATION_MESSAGE);
    }
}
