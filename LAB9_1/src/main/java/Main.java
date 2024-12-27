//Task 1. Parallel algorithm and shared state
//Переказ коштів
//У Вас є клас Bank з методом transfer () для переказу грошей з одного
//рахунку на інший в межах банку.
//public class Bank {
//    public void transfer(Account from, Account to,
//                         int amount){
//        atomic {
//            from.withdraw(amount);
//            to.deposit(amount);
//        }
//    }
//}
//На жаль, в Java відсутня конструкція типу atomic для виконання
//транзакцій.
//Напишіть свою реалізація тіла методу transfer(), яка могла б працювати в
//багатопотоковому середовищі.
//Під час переказу грошей з рахунку на рахунок, дані рахунки повинні
//блокуватися. Подумайте, як при цьому уникнути deadlock-ів.
//Виконайте тестування методу transfer(). Для цього:
//1 Створіть кілька десятків (сотень) рахунків і покладіть на них
//випадкову кількість грошей
//2 Підрахуйте скільки всього є грошей (сума грошей на всіх рахунках)
//3 Запустіть в декількох тисячах потоків одночасний переклад
//випадкових сум грошей з випадкового рахунку на випадковий
//рахунок (сума на рахунку не може бути негативною)
//Дочекайтеся закінчення переказів і підрахуйте скільки грошей є всього в
//банку (сума грошей на всіх рахунках). Сума грошей в банку до перекладів
//і після, повинні збігатися


public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account[] accounts = new Account[1000];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, (int) (Math.random() * 1000));
        }

        int totalBalanceBefore = 0;

        for (Account account : accounts) {
            totalBalanceBefore += account.getBalance();
        }

        long startTime = System.nanoTime();
        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int fromIndex = (int) (Math.random() * accounts.length);
                int toIndex = (int) (Math.random() * accounts.length);

                while (fromIndex == toIndex) {
                    toIndex = (int) (Math.random() * accounts.length);
                }

                int amount = (int) (Math.random() * accounts[fromIndex].getBalance());
                bank.transfer(accounts[fromIndex], accounts[toIndex], amount);
            });
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalBalanceAfter = 0;
        for (Account account : accounts) {
            totalBalanceAfter += account.getBalance();
        }

        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000_000.0;

        System.out.println("\nBalance before: " + totalBalanceBefore);
        System.out.println("Balance after: " + totalBalanceAfter);
        System.out.printf("Time: %.3fs\n", duration);
    }
}

