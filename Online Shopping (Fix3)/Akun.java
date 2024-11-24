public class Akun {
    private String id;
    protected String name;  // Menggunakan protected agar bisa diakses oleh subclass
    private String password;

    // Konstruktor hanya dengan ID
    public Akun(String id) {
        this.id = id;
        this.name = "Default Name"; // Nama default jika tidak diatur
        this.password = "defaultPassword"; // Password default jika tidak diatur
    }

    // Konstruktor dengan ID, Name, dan Password
    public Akun(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    // Getter untuk ID
    public String getId() {
        return id;
    }

    // Getter untuk Name
    public String getName() {
        return name;
    }

    // Getter untuk Password
    public String getPassword() {
        return password;
    }

    // Setter untuk Name (untuk mengubah nama jika diperlukan)
    public void setName(String name) {
        this.name = name;
    }

    // Setter untuk Password (untuk mengubah password jika diperlukan)
    public void setPassword(String password) {
        this.password = password;
    }
}
