import java.util.HashMap;
import java.util.Map;

/**
 * Created by abdullahodibat.
 */
public class FlyWeight {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car car = carFactory.getCar("bmw");
        car.setColor("blue");
        car.setPrice(10);
        System.out.println(car);
        Car car2 = carFactory.getCar("bmw");
        car2.setColor("green");
        car2.setPrice(11);
        System.out.println(car2);
    }

    static class Car {
        String brand;
        String color;
        int price;

        public Car(String brand) {
            this.brand = brand;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "brand: " + brand + ", color: " + color + ", price: " + price;
        }
    }

    static class CarFactory {
        Map<String, Car> cars;

        public CarFactory() {
            this.cars = new HashMap<>();
        }

        Car getCar(String brand) {
            Car car;
            car = cars.get(brand);
            if (car == null) {
                car = new Car(brand);
                cars.put(brand, car);
                System.out.println("create car with brancd : " + brand);
            }
            return car;
        }
    }
}
