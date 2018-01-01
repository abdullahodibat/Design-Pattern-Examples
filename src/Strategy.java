import java.util.Collections;

/**
 * Created by abdullahodibat.
 */
public class Strategy {

    public static void main(String[] args){
        Context context = new Context(new OperationTwo());
        context.execOpt();
    }

    static class Context {
        Operation operation;
        public Context(Operation operation){
            this.operation=operation;
        }

        public void execOpt(){
            operation.doOpt();
        }
    }

    interface Operation {
        void doOpt();
    }
    static class OperationOne implements Operation{

        @Override
        public void doOpt() {
            System.out.println("doing operation 1");
        }
    }
    static class OperationTwo implements Operation{

        @Override
        public void doOpt() {
            System.out.println("doing operation 2");
        }
    }
    static class OperationThree implements Operation{

        @Override
        public void doOpt() {
            System.out.println("doing operation 3");
        }
    }
}
