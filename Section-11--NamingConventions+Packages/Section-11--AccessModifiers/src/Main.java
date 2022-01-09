public class Main {

    public static void main(String[] args) {
        Account willsAccount = new Account("Will");
        willsAccount.deposit(1000);
        willsAccount.withdraw(500);
        willsAccount.withdraw(-200);
        willsAccount.deposit(-20);
        willsAccount.calculateBalance();

        System.out.println(" Balance on account is " + willsAccount.getBalance());
    }
}
