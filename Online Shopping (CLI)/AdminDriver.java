import java.util.Scanner;

public class AdminDriver {
    private ListBarang listBarang;
    private ListTransaksi listTransaksi; 

    public AdminDriver(Admin admin, ListBarang listBarang, ListTransaksi listTransaksi) {
        this.listBarang = listBarang;
        this.listTransaksi = listTransaksi;
    }
    
    private void viewAvailableItems() {
        listBarang.viewItems(); 
    }
    
    public void handleAdminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Tambahkan Item");
            System.out.println("2. Tampilkan Item");
            System.out.println("3. Edit Item");
            System.out.println("4. Hapus Item");
            System.out.println("5. Tampilkan Transaksi");
            System.out.println("6. Logout");
            System.out.print("Pilih Opsi: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listBarang.addItem(scanner); 
                    break;
                case 2:
                    viewAvailableItems();
                    break;
                case 3:
                    listBarang.editItem(scanner);
                    break;
                case 4:
                    listBarang.deleteItem(scanner);
                    break;
                case 5:
                    listTransaksi.viewTransactions();
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid! Silahkan coba lagi");
            }
        }
    }
}
