/**
 * Created by abdullahodibat.
 */
public class Prototype {

    public static void main(String[] args) {
        CloneFactory cloneFactory = new CloneFactory();
        Lion lion = new Lion();
        Lion clonedAnimal = (Lion) cloneFactory.getClone(lion);
    }

    interface Animal extends Cloneable {
        Animal clone();
    }

    static class Lion implements Animal {

        @Override
        public Animal clone() {
            System.out.println("cloning lion");
            Lion lion = null;

            try {
                lion = (Lion) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return lion;
        }
    }

    static class CloneFactory {
        public Animal getClone(Animal animal) {
            return animal.clone();
        }
    }

}
