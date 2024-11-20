import java.util.Scanner;

public class AdminDriver {
    private Admin admin;
    private ListBarang listBarang;
    private ListTransaksi listTransaksi;

    public AdminDriver(Admin admin) {
        this.admin = admin;
        this.listBarang = new ListBarang();
        this.listTransaksi = new ListTransaksi();
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
                    listBarang.addItem(scanner);
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
