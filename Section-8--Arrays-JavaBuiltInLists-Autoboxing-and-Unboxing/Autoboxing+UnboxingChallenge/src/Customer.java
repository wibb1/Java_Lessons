import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactions = new ArrayList<Double>();
    private String name;

    public Customer(double initialAmount, String name) {
        this.transactions = new ArrayList<Double>();
        this.addTransaction(initialAmount);
        this.name = name;
    }

    public void addTransaction(Double transaction) {
        this.transactions.add(transaction);
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }
}
