import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListBarang listBarang = new ListBarang();
        ListTransaksi listTransaksi = new ListTransaksi();

        Admin admin = new Admin("2308", "12345");
        Customer customer = new Customer("2308",  "default","6789");

        AdminDriver adminDriver = new AdminDriver(admin, listBarang, listTransaksi);
        CustomerDriver customerDriver = new CustomerDriver(customer, listBarang, listTransaksi);

        System.out.println("=== Selamat datang di Sistem Belanja Online ===");

        while (true) {
            System.out.println("\n1. Login Sebagai admin");
            System.out.println("2. Login Sebagai Customer");
            System.out.println("3. Keluar");
            System.out.print("Pilih Opsi: ");
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
                    System.out.println("Keluar dari system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid! Silahkan Coba lagi.");
            }
        }
    }

    // Modifikasi metode authenticate untuk menambahkan input nama
    public static Akun authenticate(Scanner scanner, Akun akun) {
        System.out.print("Masukkan ID: ");
        String id = scanner.next();
        System.out.print("Masukkan Password: ");
        String password = scanner.next();

        // Tambahkan input nama setelah ID dan password
        System.out.print("Masukkan Nama: ");
        String name = scanner.next(); // Nama yang dimasukkan

        // Cek apakah ID dan password sesuai dengan akun
        if (akun instanceof Admin && akun.getId().equals(id) && ((Admin) akun).getPassword().equals(password)) {
            System.out.println("Login Sebagai Admin berhasil! Selamat datang, " + name);
            // Set nama admin jika diperlukan
            ((Admin) akun).setNama(name);
            return akun;
        } else if (akun instanceof Customer && akun.getId().equals(id) && akun.getPassword().equals(password)) {
            System.out.println("Login Sebagai Customer berhasil! Selamat datang, " + name);
            // Set nama customer jika diperlukan
            ((Customer) akun).setName(name);
            return akun;
        } else {
            System.out.println("Kredensial tidak valid!");
            return null;
        }
    }
}
