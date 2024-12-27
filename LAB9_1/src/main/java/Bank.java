public class Bank {

    public Bank() {};

    public void transfer(Account from, Account to, int amount) {
        Account first = (from.getId() <= to.getId()) ? from : to;
        Account second = (from.getId() <= to.getId()) ? to : from;

        synchronized (first) {
            synchronized (second) {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                    System.out.println("Transferring " + amount + "grn from balance №"
                            + from.getId() + " to balance №" + to.getId());
                } else {
                    System.out.println("Error: not enough money to transfer "
                            + amount + "grn from balance №" + from.getId());
                }
            }
        }
    }

}