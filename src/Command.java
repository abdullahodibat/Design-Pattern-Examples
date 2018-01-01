import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdullahodibat.
 */
public class Command {

    public static void main(String[] args) {
        Command.Product product = new Command.Product();
        Command.BuyProduct buyProduct = new Command.BuyProduct(product);
        Command.SellProduct sellProduct = new Command.SellProduct(product);

        Command.Broker broker = new Command.Broker();
        broker.addOrder(buyProduct);
        broker.addOrder(sellProduct);

        broker.executeOrders();
    }

    public interface Order {
        void execute();
    }

    static class Product {
        public void sell() {
            System.out.println("selled product");
        }

        public void buy() {
            System.out.println("bought product");
        }

        public void incrementStock() {
            System.out.println("increase stock +1");
        }

        public void decrementStock() {
            System.out.println("decrement stock -1");
        }
    }

    static class BuyProduct implements Order {
        Product product;

        public BuyProduct(Product product) {
            this.product = product;
        }

        @Override
        public void execute() {
            product.buy();
            product.incrementStock();
        }
    }

    static class SellProduct implements Order {
        Product product;

        public SellProduct(Product product) {
            this.product = product;
        }

        @Override
        public void execute() {
            product.sell();
            product.decrementStock();
        }
    }

    static class Broker {
        private List<Order> orders = new ArrayList<>();

        public void addOrder(Order order) {
            this.orders.add(order);
        }

        public void executeOrders() {
            for (Order o : orders) {
                o.execute();
            }
            orders.clear();
        }
    }
}
