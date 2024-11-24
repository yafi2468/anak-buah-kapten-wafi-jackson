import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat instance shared ListBarang dan ListTransaksi
        ListBarang listBarang = new ListBarang();
        ListTransaksi listTransaksi = new ListTransaksi();

        // Membuat driver untuk admin dan customer
        AdminDriver adminDriver = new AdminDriver(new Admin("admin"), listBarang, listTransaksi);
        CustomerDriver customerDriver = new CustomerDriver(new Customer("customer"), listBarang, listTransaksi);

        System.out.println("=== Welcome to the Online Shopping System ===");

        while (true) {
            System.out.println("\n1. Login as Admin");
            System.out.println("2. Login as Customer");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminDriver.handleAdminMenu(scanner);
                    break;
                case 2:
                    customerDriver.start(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
