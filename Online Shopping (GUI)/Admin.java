import javax.swing.*;

public class Admin extends Akun {
    private final String password;

    public Admin(String id, String password) {
        super(id);
        this.password = password;
    }

    /**
     *
     * @return
     */
    @Override
    public String getPassword() {
        return password;
    }

    public void displayAdminDetails() {
        String adminDetails = "Admin ID: " + getId() + "\nPassword: " + password;
        JOptionPane.showMessageDialog(null, adminDetails, "Admin Details", JOptionPane.INFORMATION_MESSAGE);
    }
}
