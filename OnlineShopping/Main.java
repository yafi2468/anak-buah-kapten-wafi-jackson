import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminDriver adminDriver = new AdminDriver(new Admin("admin"));
        CustomerDriver customerDriver = new CustomerDriver(new Customer("customer"));

        System.out.println("=== Welcome to the Online Shopping System ===");

        while (true) {
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Customer");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminDriver.handleAdminMenu(scanner);
                    break;
                case 2:
                    customerDriver.handleCustomerMenu(scanner);
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
