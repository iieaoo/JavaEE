package thread;

public class ThreadDemo7 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("hello thread");
        });
        t.start();
        System.out.println("hello main");
    }
}
