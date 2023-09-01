package thread;

public class ThreadDemo16 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object) {
            System.out.println("wait 之前");
            object.wait();
            System.out.println("wait 之后");
        }
    }
}
