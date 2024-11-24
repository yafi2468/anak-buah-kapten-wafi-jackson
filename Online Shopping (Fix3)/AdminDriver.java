import java.util.Scanner;

public class AdminDriver {
    private Admin admin;
    private ListBarang listBarang; // Shared ListBarang
    private ListTransaksi listTransaksi; // Shared ListTransaksi

    public AdminDriver(Admin admin, ListBarang listBarang, ListTransaksi listTransaksi) {
        this.admin = admin;
        this.listBarang = listBarang;
        this.listTransaksi = listTransaksi;
    }

    public void handleAdminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Add Item");
            System.out.println("2. Edit Item");
            System.out.println("3. Delete Item");
            System.out.println("4. View Transactions");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listBarang.addItem(scanner); // Menggunakan instance ListBarang yang sama
                    break;
                case 2:
                    listBarang.editItem(scanner);
                    break;
                case 3:
                    listBarang.deleteItem(scanner);
                    break;
                case 4:
                    listTransaksi.viewTransactions();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
