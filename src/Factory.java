/**
 * Created by abdullahodibat.
 */
public class Factory {

    public static void main(String[] args) {
        Factory animalFactory = new Factory();
        Animal dog = animalFactory.getAnimal("park");
        Animal cat = animalFactory.getAnimal("meo");
        Animal cow = animalFactory.getAnimal("moo");
        dog.sound();
        cat.sound();
        cow.sound();
    }

    public Animal getAnimal(String sound) {
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

    interface Animal {
        void sound();
    }

    private class Dog implements Animal {

        @Override
        public void sound() {
            System.out.println("park");
        }
    }

    private class Cat implements Animal {

        @Override
        public void sound() {
            System.out.println("meo");
        }
    }

    private class Cow implements Animal {

        @Override
        public void sound() {
            System.out.println("moo");
        }
    }
}
