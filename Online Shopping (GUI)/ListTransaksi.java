import javax.swing.*;
import java.util.ArrayList;

public class ListTransaksi {
    private final ArrayList<Transaksi> transactions;
    
    public ListTransaksi() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaksi transaksi) {
        transactions.add(transaksi);
    }

    public void viewTransactions() {
        if (transactions.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No transactions available.", "Transactions", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder sb = new StringBuilder("=== Transactions ===\n");
            for (int i = 0; i < transactions.size(); i++) {
                sb.append(i + 1).append(". ").append(transactions.get(i).toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString(), "Transactions", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Menambahkan metode untuk mendapatkan transaksi terakhir
    public Transaksi getLatestTransaction() {
        if (transactions.isEmpty()) {
            return null; // Mengembalikan null jika tidak ada transaksi
        }
        return transactions.get(transactions.size() - 1); // Mengambil transaksi terakhir
    }
}
