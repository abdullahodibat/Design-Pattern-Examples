/**
 * Created by abdullahodibat.
 */
public class VisitorPattern {

    public static void main(String[] args) {
        VehicleVisitor vehicleVisitor = new VehicleVisitor();
        Car car = new Car();
        Truck truck = new Truck();
        Bike bike = new Bike();

        System.out.println(car.accept(vehicleVisitor));
    }

    interface Visitable {
        int price();

        int accept(Visitor visitor);
    }

    interface Visitor {
        int visit(Car car);

        int visit(Truck truck);

        int visit(Bike bike);
    }

    static class VehicleVisitor implements Visitor {

        @Override
        public int visit(Car car) {
            System.out.println("doubling car price car");
            return car.price() * 2;
        }

        @Override
        public int visit(Truck truck) {
            System.out.println("doubling truck price car");
            return truck.price() * 2;
        }

        @Override
        public int visit(Bike bike) {
            System.out.println("doubling bike price car");
            return bike.price() * 2;
        }
    }

    static class Car implements Visitable {

        @Override
        public int price() {
            return 10;
        }

        @Override
        public int accept(Visitor visitor) {
            return visitor.visit(this);
        }
    }

    static class Truck implements Visitable {

        @Override
        public int price() {
            return 20;
        }

        @Override
        public int accept(Visitor visitor) {
            return visitor.visit(this);
        }
    }

    static class Bike implements Visitable {

        @Override
        public int price() {
            return 5;
        }

        @Override
        public int accept(Visitor visitor) {
            return visitor.visit(this);
        }
    }
}
