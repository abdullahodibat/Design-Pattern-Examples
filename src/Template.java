/**
 * Created by abdullahodibat.
 */
public class Template {
    public static void main(String[] args) {
        Game football = new Football();
        football.play();
        Game basketball = new Basketball();
        basketball.play();


    }

    public abstract static class Game {
        abstract void start();

        abstract void end();

        public final void play() {
            start();
            end();
        }
    }

    static class Football extends Game {

        @Override
        void start() {
            System.out.println("start football");
        }

        @Override
        void end() {
            System.out.println("end football");
        }
    }

    static class Basketball extends Game {

        @Override
        void start() {
            System.out.println("start Basketball");
        }

        @Override
        void end() {
            System.out.println("end Basketball");
        }
    }
}
