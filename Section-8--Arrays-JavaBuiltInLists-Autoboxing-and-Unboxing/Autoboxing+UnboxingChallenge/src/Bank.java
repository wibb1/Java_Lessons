import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        System.out.println(branchName + " branch already exists.");
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double transaction) {
        Branch currentBranch = findBranch(branchName);
        if (findBranch(branchName) != null) {
            return currentBranch.newCustomer(customerName, transaction);
        }
        System.out.println(branchName + " branch does not exist.");
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, transaction);
        }
        System.out.println(branchName + " branch does not exist.");
        return false;
    }

    private Branch findBranch(String name) {
        for (int i = 0; i < this.branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if (branch.getBranchName().equals(name)) {
                return branch;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getBranchName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer customer = branchCustomers.get(i);
                System.out.println("Customer Name: " + customer.getName() + "[" + (i + 1) + "]");
                if (showTransactions) {
                    System.out.println("Transactions: ");
                    ArrayList<Double> transactions = customer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "]" + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
