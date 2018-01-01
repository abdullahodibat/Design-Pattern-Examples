import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdullahodibat.
 */
public class MementoPattern {

    public static void  main (String[] args) {
        MementoList mementoList = new MementoList();
        Machine machine = new Machine("off");
        machine.changeState("on");
        mementoList.addmemento(machine.saveStateToMemento());
        machine.changeState("idle");
        mementoList.addmemento(machine.saveStateToMemento());

        System.out.println(mementoList.mementos.get(0).state);
        System.out.println(mementoList.mementos.get(1).state);

    }

    static class Memento {
        String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return this.state;
        }
    }

    static class Machine {
        String state;
        public Machine(String state) {
            this.state=state;
        }
        public void changeState(String state){
            this.state=state;
        }

        public Memento saveStateToMemento(){
            return new Memento(state);
        }
    }

    static class MementoList {
        List<Memento> mementos;

        public MementoList(){
            this.mementos = new ArrayList<>();
        }

        public void addmemento(Memento memento){
            this.mementos.add(memento);
        }

    }

}
