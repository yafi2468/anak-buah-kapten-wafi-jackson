public class Admin extends Akun {
    private String password;
    private String nama;  // Menambahkan atribut nama

    public Admin(String id, String password) {
        super(id); 
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    // Menambahkan setter dan getter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
}
