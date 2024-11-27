import javax.swing.*;

public class Akun {
    private String id;
    protected String name;
    private String password;

    public Akun(String id) {
        this.id = id;
        this.name = "Default Name";
        this.password = "defaultPassword";
    }

    public Akun(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void displayAccountInfo() {
        String info = "Account ID: " + id + "\nName: " + name + "\nPassword: " + password;
        JOptionPane.showMessageDialog(null, info, "Account Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
