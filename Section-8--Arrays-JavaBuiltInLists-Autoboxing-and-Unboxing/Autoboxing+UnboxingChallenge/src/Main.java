public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("First National");

        bank.addBranch("New York");

        bank.addCustomer("New York", "Tom Thumb", 65.21);
        bank.addCustomerTransaction("New York", "Tom Thumb", 16.5);
        bank.addCustomerTransaction("New York", "Tom Thumb", 689.26);

        bank.addCustomer("New York", "Mr. Peanut", 0.05);
        bank.addCustomerTransaction("New York", "Mr. Peanut", 1.05);
        bank.addCustomerTransaction("New York", "Mr. Peanut", 1.1);
        bank.addCustomerTransaction("New York", "Mr. Peanut", 0.8);

        bank.addBranch("Chicago");

        bank.addCustomer("Chicago", "Jack Black", 200.36);
        bank.addCustomerTransaction("Chicago", "Jack Black", 25689.68);
        bank.addCustomerTransaction("Chicago", "Jack Black", 25689.68);

        bank.listCustomers("New York", false);
        bank.listCustomers("New York", true);
        bank.listCustomers("Chicago", false);

        bank.addCustomer("Boston", "Brian", 0.00);

        bank.addCustomerTransaction("Chicago", "Jack Blue", 259.36);

        bank.addCustomer("Chicago", "Jack Black", 10.0);

        bank.addBranch("New York");
    }
}
