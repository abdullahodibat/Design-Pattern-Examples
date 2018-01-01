/**
 * Created by abdullahodibat.
 */
public class Proxy {
    public static void main(String[] args) {
        Proxy.ProxyAccount proxyAccount = new Proxy.ProxyAccount();
        Proxy.Account account = proxyAccount.getById(1);
        account.printData();
    }

    static class Account {
        String username;
        String password;

        public Account(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public void printData() {
            System.out.println("username: " + this.username + ", password:" + this.password);
        }

        public static Account getById(int id) {
            return new Account("admin", "pass123");
        }
    }

    static class ProxyAccount {
        public Account getById(int id) {
            Account account = Account.getById(id);
            account.password = "*****";
            return account;
        }
    }
}
