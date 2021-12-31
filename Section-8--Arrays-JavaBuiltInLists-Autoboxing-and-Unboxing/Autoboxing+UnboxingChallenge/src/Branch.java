import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public void addCustomer(String name, double transaction) {
        Customer newCustomer = new Customer(transaction, name);
    }

    public String getBranchName() {
        return branchName;
    }

    public boolean newCustomer(String name, double transaction) {
        if (findCustomer(name) == null) {
            this.customers.add(new Customer(transaction, name));
            return true;
        }
        System.out.println(name + " already exists.");
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double transaction) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(transaction);
            return true;
        }
        System.out.println(customerName + " does not exist.");
        return false;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private Customer findCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = this.customers.get(i);
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
}
