/**
 * Created by abdullahodibat.
 */
public class Decorator {

    public static void main(String[] args){
        CarBuilder carBuilder = new CarBuilder();
        CarPolisher carPolisher = new CarPolisher(carBuilder);
        carPolisher.build();
    }

    interface car {
        void build();
    }

    static class CarBuilder implements car {

        @Override
        public void build() {
            System.out.println("building car");
        }
    }

    abstract static class CarDecorator implements car {
        CarBuilder carBuilder;
        public CarDecorator(CarBuilder carBuilder){
            this.carBuilder=carBuilder;
        }

        @Override
        public void build() {
            carBuilder.build();
        }
    }

    static class CarPolisher extends CarDecorator {

        public CarPolisher(CarBuilder carBuilder) {
            super(carBuilder);
        }
        @Override
        public void build(){
           carBuilder.build();
           polish();

        }
        public void polish(){
            System.out.println("polishing car");
        }
    }
}
