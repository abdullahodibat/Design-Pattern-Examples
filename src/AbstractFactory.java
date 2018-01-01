/**
 * Created by abdullahodibat.
 */
public class AbstractFactory {


    public static void main(String[] args) {
        AbstractAnimalFactory animalFactory = FactoryProducer.getFactory("animal");
        AbstractAnimalFactory fishFactory = FactoryProducer.getFactory("fish");

        Animal dog = animalFactory.getAnimal("park");
        Animal cat = animalFactory.getAnimal("meo");
        Animal cow = animalFactory.getAnimal("moo");
        dog.sound();
        cat.sound();
        cow.sound();

        Fish salamon = fishFactory.getFish("salamon");
        salamon.name();
    }

    public static class FactoryProducer {
        public static AbstractAnimalFactory getFactory(String choice) {

            if (choice.equals("animal")) {
                return new AnimalFactory();

            } else if (choice.equals("fish")) {
                return new FishFactory();
            }

            return null;
        }
    }

    public abstract static class AbstractAnimalFactory {
        abstract Animal getAnimal(String sound);

        abstract Fish getFish(String name);
    }

    static class AnimalFactory extends AbstractAnimalFactory {
        @Override
        Animal getAnimal(String sound) {
            switch (sound) {
                case "meo":
                    return new Cat();
                case "moo":
                    return new Cow();
                case "park":
                    return new Dog();
                default:
                    return null;
            }
        }

        @Override
        Fish getFish(String name) {
            return null;
        }

    }

    static class FishFactory extends AbstractAnimalFactory {
        @Override
        public Animal getAnimal(String sound) {
            return null;
        }

        @Override
        Fish getFish(String name) {
            switch (name) {
                case "salamon":
                    return new Salamon();
                default:
                    return null;
            }
        }

    }

    interface Animal {
        void sound();
    }


    interface Fish {
        void name();
    }

    static private class Salamon implements Fish {

        @Override
        public void name() {
            System.out.println("salamon");
        }
    }

    static private class Dog implements Animal {

        @Override
        public void sound() {
            System.out.println("park");
        }
    }

    static private class Cat implements Animal {

        @Override
        public void sound() {
            System.out.println("meo");
        }
    }

    static private class Cow implements Animal {

        @Override
        public void sound() {
            System.out.println("moo");
        }
    }
}
