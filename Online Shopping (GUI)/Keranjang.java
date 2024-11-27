import java.util.ArrayList;
import javax.swing.*;

public class Keranjang {
    private ArrayList<Barang> itemsInCart;

    public Keranjang() {
        itemsInCart = new ArrayList<>();
    }

    // Menambahkan item ke dalam keranjang (dengan objek Barang)
    public void addItemToCart(Barang item) {
        System.out.println("Menambahkan item ke keranjang: " + item.getNama() + " dengan harga: Rp" + item.getHarga()); // Debugging
        itemsInCart.add(item);
    }

    // Menampilkan barang yang ada di keranjang
    public void viewCart() {
        if (itemsInCart.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Keranjangmu masih kosong.");
        } else {
            StringBuilder sb = new StringBuilder("Items di keranjanngmu:\n");
            for (Barang item : itemsInCart) {
                sb.append(item.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    // Cek apakah keranjang kosong
    public boolean isCartEmpty() {
        return itemsInCart.isEmpty();
    }

    // Menambahkan metode untuk mendapatkan daftar barang di keranjang
    public ArrayList<Barang> getItems() {
        return itemsInCart;  // Mengembalikan daftar barang yang ada di keranjang
    }

    // Menambahkan metode untuk mengosongkan keranjang setelah checkout
    public void clearCart() {
        itemsInCart.clear();  // Mengosongkan semua item di keranjang
        System.out.println("Keranjang telah dikosongkan.");
    }
}
