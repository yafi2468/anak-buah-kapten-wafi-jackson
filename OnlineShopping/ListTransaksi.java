import java.util.ArrayList;

public class ListTransaksi {
    private ArrayList<Transaksi> transactions;

    public ListTransaksi() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaksi transaksi) {
        transactions.add(transaksi);
    }

    public void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (int i = 0; i < transactions.size(); i++) {
                System.out.println((i + 1) + ". " + transactions.get(i));
            }
        }
    }
}
