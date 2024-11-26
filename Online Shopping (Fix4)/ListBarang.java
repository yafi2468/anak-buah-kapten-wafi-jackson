import java.util.ArrayList;
import java.util.Scanner;

public class ListBarang {
    private ArrayList<Barang> items;

    public ListBarang() {
        this.items = new ArrayList<>();
    }

    public ArrayList<Barang> getBarang() {
        return items;
    }

    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("Tidak ada Item yang tersedia!");
        } else {
            System.out.println("=== Item Tersedia ===");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }
    }

    public void addItem(Scanner scanner) {
        boolean adding = true;

        while (adding) {
            System.out.print("Masukkan Nama Barang: ");
            scanner.nextLine(); // Consume leftover newline
            String name = scanner.nextLine();
            System.out.print("Masukkan Harga Barang: ");
            double price = scanner.nextDouble();
            items.add(new Barang(name, price));
            System.out.println("Item Berhasil ditambahkan");

            System.out.print("Apakah Anda ingin menambahkan barang lagi? (y/n): ");
            scanner.nextLine(); // Consume leftover newline
            String choice = scanner.nextLine().toLowerCase();

            if (!choice.equals("y")) {
                adding = false;
            }
        }
    }

    public void editItem(Scanner scanner) {
        if (items.isEmpty()) {
            System.out.println("Tidak ada Item untuk di Edit");
            return;
        }

        viewItems();
        System.out.print("Pilih Nomor Item yang ingin di Edit: ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= items.size()) {
            System.out.println("Pilihan tidak Valid!");
            return;
        }

        System.out.print("Masukkan Nama baru Item: ");
        scanner.nextLine(); // Consume leftover newline
        String newName = scanner.nextLine();
        System.out.print("Masukkan Harga Baru Item: ");
        double newPrice = scanner.nextDouble();

        items.get(index).setNama(newName);
        items.get(index).setHarga(newPrice);
        System.out.println("Item telah berhasil diperbarui!");
    }

    public void deleteItem(Scanner scanner) {
        if (items.isEmpty()) {
            System.out.println("Tidak ada Item Untuk di Hapus!");
            return;
        }

        viewItems();
        System.out.print("Pilih Nomor Item yang ingin di Hapus: ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= items.size()) {
            System.out.println("Pilihan tidak Valid");
            return;
        }

        items.remove(index);
        System.out.println("Item telah berhasil dihapus!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListBarang listBarang = new ListBarang();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Lihat Item");
            System.out.println("2. Tambah Item");
            System.out.println("3. Edit Item");
            System.out.println("4. Hapus Item");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listBarang.viewItems();
                    break;
                case 2:
                    listBarang.addItem(scanner);
                    break;
                case 3:
                    listBarang.editItem(scanner);
                    break;
                case 4:
                    listBarang.deleteItem(scanner);
                    break;
                case 5:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }
}