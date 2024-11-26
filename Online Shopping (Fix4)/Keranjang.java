import java.util.ArrayList;
import java.util.Scanner;

public class Keranjang {
    private ArrayList<Barang> items;

    public Keranjang() {
        this.items = new ArrayList<>();
    }

    public ArrayList<Barang> getItems() {
        return items;
    }

    public void addItem(Scanner scanner, ListBarang listBarang) {
        if (listBarang.getBarang().isEmpty()) {
            System.out.println("Tidak ada item yang tersedia untuk ditambahkan.");
            return;
        }

        listBarang.viewItems();
        System.out.print("Pilih nomor barang untuk ditambahkan ke keranjang: ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= listBarang.getBarang().size()) {
            System.out.println("Pilihan Tidak Valid!");
            return;
        }

        items.add(listBarang.getBarang().get(index));
        System.out.println("Item Sudah ditambahkan ke Keranjang");
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Keranjangmu Kosong");
        } else {
            System.out.println("=== Keranjangmu ===");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clearCart() {
        items.clear();
    }
}
