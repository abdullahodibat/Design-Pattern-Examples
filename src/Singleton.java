/**
 * Created by abdullahodibat.
 */
public class Singleton {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.databaseURL);
    }

    String databaseURL = "http:/...";
    String databaseUser = "admin";

    private Singleton() {

    }

    private static Singleton instance = new Singleton();

    static Singleton getInstance() {
        return instance;
    }
}
