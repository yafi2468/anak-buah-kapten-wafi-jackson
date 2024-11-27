public class Akun {
    private String id;
    protected String name;  // Atribut name, diubah menjadi protected agar dapat diakses oleh subclass
    private String password;

    // Konstruktor dengan ID saja (menetapkan nama dan password default)
    public Akun(String id) {
        this.id = id;
        this.name = "Default Name";  // Nama default
        this.password = "defaultPassword";  // Password default
    }

    // Konstruktor dengan ID, nama, dan password (untuk login dengan nama pengguna)
    public Akun(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    // Getter untuk ID
    public String getId() {
        return id;
    }

    // Getter untuk Nama
    public String getName() {
        return name;
    }

    // Setter untuk Nama
    public void setName(String name) {
        this.name = name;  // Menyimpan nama pengguna
    }

    // Getter untuk Password
    public String getPassword() {
        return password;
    }

    // Setter untuk Password
    public void setPassword(String password) {
        this.password = password;  // Menyimpan password
    }
}
