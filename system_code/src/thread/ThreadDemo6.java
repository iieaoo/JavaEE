package thread;

public class ThreadDemo6 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("hello");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "mythread");
        t.start();

        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(t.isAlive());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
