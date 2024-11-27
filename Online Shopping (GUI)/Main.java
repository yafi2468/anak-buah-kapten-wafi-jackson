import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListBarang listBarang = new ListBarang();
        ListTransaksi listTransaksi = new ListTransaksi();

        Admin admin = new Admin("2308", "12345");
        Customer customer = new Customer("2308", "Reky", "6789");

        AdminDriver adminDriver = new AdminDriver(admin, listBarang, listTransaksi);
        CustomerDriver customerDriver = new CustomerDriver(customer, listBarang, listTransaksi);

        String menu = """
                      === Selamat Datang di Sistem Belanja Online ===
                      
                      1. Login sebagai Admin
                      2. Login sebagai Customer
                      3. Keluar
                      Pilih opsi:""";
        while (true) {
            String choice = JOptionPane.showInputDialog(null, menu);
            if (choice != null) {
                int option = Integer.parseInt(choice);
                switch (option) {
                    case 1:
                        if (authenticate(scanner, admin)) {
                            adminDriver.handleAdminMenu();
                        }
                        break;
                    case 2:
                        if (authenticate(scanner, customer)) {
                            customerDriver.start();
                        }
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Keluar dari sistem. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        JOptionPane.showMessageDialog(null, "Pilihan tidak valid! Silakan coba lagi.");
                }
            }
        }
    }

    public static boolean authenticate(Scanner scanner, Akun akun) {
        String id = JOptionPane.showInputDialog(null, "Masukkan ID:");
        String password = JOptionPane.showInputDialog(null, "Masukkan Password:");
        String name = JOptionPane.showInputDialog(null, "Masukkan Nama:");

        akun.setName(name);

        if (akun instanceof Admin && akun.getId().equals(id) && ((Admin) akun).getPassword().equals(password)) {
            JOptionPane.showMessageDialog(null, "Login sebagai Admin berhasil! Selamat datang " + name + "!");
            return true;
        } else if (akun instanceof Customer && akun.getId().equals(id) && akun.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(null, "Login sebagai Customer berhasil! Selamat datang " + name + "!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Kredensial tidak valid!");
            return false;
        }
    }
}
