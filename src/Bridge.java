/**
 * Created by abdullahodibat.
 */
public class Bridge {

    public static void main(String[] args) {

        Building building1 = new House(new RedPainting());
        Building building2 = new Villa(new BluePainting());

        building1.build();
        building2.build();
    }

    abstract static class Building {
        Painting painting;

        public Building(Painting painting) {
            this.painting = painting;
        }

        public abstract void build();
    }

    interface Painting {
        void paint();
    }

    static class BluePainting implements Painting {

        @Override
        public void paint() {
            System.out.println("painging blue");
        }
    }

    static class RedPainting implements Painting {

        @Override
        public void paint() {
            System.out.println("painting red");
        }
    }

    static class House extends Building {

        public House(Painting painting) {
            super(painting);
        }

        @Override
        public void build() {
            System.out.println("building house");
            painting.paint();
        }
    }

    static class Villa extends Building {
        public Villa(Painting painting) {
            super(painting);
        }

        @Override
        public void build() {
            System.out.println("building villa");
            painting.paint();
        }
    }

}
