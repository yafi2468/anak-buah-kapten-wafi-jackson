import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat instance shared ListBarang dan ListTransaksi
        ListBarang listBarang = new ListBarang();
        ListTransaksi listTransaksi = new ListTransaksi();

        // Membuat objek Admin dan Customer
        Admin admin = new Admin("2308", "12345");
        Customer customer = new Customer("2308", "Reky", "6789");

        // Membuat driver untuk Admin dan Customer
        AdminDriver adminDriver = new AdminDriver(admin, listBarang, listTransaksi);
        CustomerDriver customerDriver = new CustomerDriver(customer, listBarang, listTransaksi);

        System.out.println("=== Welcome to the Online Shopping System ===");

        while (true) {
            System.out.println("\n1. Login as Admin");
            System.out.println("2. Login as Customer");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (authenticate(scanner, admin) != null) {
                        adminDriver.handleAdminMenu(scanner);
                    }
                    break;
                case 2:
                    if (authenticate(scanner, customer) != null) {
                        customerDriver.start(scanner);
                    }
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

    // Metode untuk mengautentikasi login
    public static Akun authenticate(Scanner scanner, Akun akun) {
        System.out.print("Enter ID: ");
        String id = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();

        if (akun instanceof Admin && akun.getId().equals(id) && ((Admin) akun).getPassword().equals(password)) {
            System.out.println("Admin login successful!");
            return akun;
        } else if (akun instanceof Customer && akun.getId().equals(id) && akun.getPassword().equals(password)) {
            System.out.println("Customer login successful!");
            return akun;
        } else {
            System.out.println("Invalid credentials!");
            return null;
        }
    }
}
