/**
 * Created by abdullahodibat.
 */
public class Facade {

    public static void main(String[] args) {
        BankFacade bankFacade = new BankFacade();
        bankFacade.withdraw(22, 100);
    }

    static class AccountChecker {
        public boolean isAccountAvailable(int accountNumer) {
            return accountNumer == 22;
        }
    }

    static class AccountBalance {
        public boolean hasMoney(int euros) {
            return euros < 1000;
        }
    }

    static class AccountWithdraw {
        public void withdraw(int euros) {
            System.out.println("withdrawing " + euros + " euros");
        }
    }

    static class BankFacade {
        AccountChecker accountChecker = new AccountChecker();
        AccountBalance accountBalance = new AccountBalance();
        AccountWithdraw accountWithdraw = new AccountWithdraw();

        public void withdraw(int accountNumber, int euros) {
            if (accountChecker.isAccountAvailable(22) && accountBalance.hasMoney(euros))
                accountWithdraw.withdraw(euros);
        }
    }
}
