public class Admin extends Akun {
    private String password;

    public Admin(String id, String password) {
        super(id); 
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
