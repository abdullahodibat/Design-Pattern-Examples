/**
 * Created by abdullahodibat.
 */
public class Mediator {
    public static void main(String[] args) {
        User john = new User("john");
        User jack = new User("jack");
        john.sendMessages("hi");
        jack.sendMessages("hello");
    }
    static class MessageCenter{
        public static void showMessage(User user, String message){
            System.out.println("message: "+message+", from user: "+user.name);
        }
    }

    static class User {
        String name;
        public User(String name){
            this.name=name;
        }

        public void sendMessages(String msg){
            MessageCenter.showMessage(this,msg);
        }
    }
}
