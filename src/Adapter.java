/**
 * Created by abdullahodibat.
 */
public class Adapter {

    public static void main(String[] args) {
        Adapter.ProductAdpter adpter = new Adapter.ProductAdpter();
        adpter.getProductDetails();
    }

    public interface ProductDetails {
        void getProductDetails();
    }

    static class Product {
        public String getName() {
            return "product name";
        }

        public String getImage() {
            return "product image";
        }

        public int getPrice() {
            return 10;
        }
    }

    static class ProductAdpter extends Product implements ProductDetails {

        @Override
        public void getProductDetails() {
            System.out.println("name: " + getName() + " image: " + getImage() + " price: " + getPrice());
        }
    }
}
