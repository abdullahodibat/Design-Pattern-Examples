import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdullahodibat.
 */
public class Observer {

    public static void main(String[] args) {
        Observer.Stock stock = new Observer.Stock();
        Observer.Environment staging = new Observer.Staing();
        Observer.Environment prod = new Observer.Production();
        Observer.Environment dev = new Observer.Dev();
        stock.attach(staging);
        stock.attach(prod);
        stock.attach(dev);

        stock.setStock(10);
    }

    abstract static class Environment {
        public abstract void update();
    }

    static class Production extends Environment {
        @Override
        public void update() {
            System.out.println("updating production stock");
        }
    }

    static class Staing extends Environment {
        @Override
        public void update() {
            System.out.println("updating staging stock");
        }
    }

    static class Dev extends Environment {
        @Override
        public void update() {
            System.out.println("updating dev stock");
        }
    }

    static class Stock {

        private List<Environment> environments = new ArrayList<>();
        private int stock;

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
            notifyAllEnvironments();
        }

        public void attach(Environment env) {
            environments.add(env);
        }

        public void notifyAllEnvironments() {
            for (Environment env : environments) {
                env.update();
            }
        }
    }
}
