/**
 * Created by abdullahodibat.
 */
public class StatePattern {
    public static void main(String[] args){
        Context context = new Context();
        OnState onState = new OnState(context);
        OffState offState = new OffState(context);
        System.out.println(context.state);
    }
    interface State {
        void doAction();
    }

    static class Context {
        State state;
        public Context() {
            this.state=null;
        }

        public void setState(State state){
            this.state=state;
        }
    }
    static class OnState implements State{
        String state;
        public OnState(Context context) {
            context.setState(this);
        }

        @Override
        public String toString(){
            return "state: On";
        }

        @Override
        public void doAction() {
            System.out.print("status is on");
        }
    }
    static class OffState implements State{
        public OffState(Context context) {
            context.setState(this);
        }

        @Override
        public String toString(){
            return "state: Off";
        }
        @Override
        public void doAction() {
            System.out.print("status is off");
        }
    }
}
