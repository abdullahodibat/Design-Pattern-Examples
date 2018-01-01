/**
 * Created by abdullahodibat.
 */
public class Builder {

    public static void main(String[] args){
        CarBuilder bmwBuilder = new BMWBuilder();
        CarFactory carFactory = new CarFactory(bmwBuilder);
        carFactory.makeCar();
        Car car = carFactory.getCar();
        System.out.println(car);
    }

    interface CarPlan {
        void setEngine(String engine);

        void setBrand(String brand);

        void setWheels(String wheels);
    }

    static class Car implements CarPlan {

        String brand;
        String wheels;
        String engine;

        @Override
        public void setEngine(String engine) {
            this.engine = engine;
        }

        @Override
        public void setBrand(String brand) {
            this.brand = brand;
        }

        @Override
        public void setWheels(String wheels) {
            this.wheels = wheels;
        }

        @Override
        public String toString(){
           return "brand: "+brand+", engine: "+engine+",wheels: "+wheels;
        }
    }

    interface CarBuilder {
        void buildEngine();

        void buildBrand();

        void buildWheels();

        Car getCar();
    }

    static class BMWBuilder implements CarBuilder {
        Car car;

        public BMWBuilder() {
            this.car = new Car();
        }

        @Override
        public void buildEngine() {
            car.setEngine("bmw engine");
        }

        @Override
        public void buildBrand() {
            car.setBrand("bmw");
        }

        @Override
        public void buildWheels() {
            car.setWheels("bmw awheels");
        }

        @Override
        public Car getCar(){
            return this.car;
        }
    }

    static class CarFactory{
        CarBuilder carBuilder;
        public CarFactory(CarBuilder builder){
            this.carBuilder=builder;
        }

        public Car getCar(){
            return this.carBuilder.getCar();
        }

        public void makeCar(){
            carBuilder.buildBrand();
            carBuilder.buildEngine();
            carBuilder.buildWheels();
        }
    }

}
