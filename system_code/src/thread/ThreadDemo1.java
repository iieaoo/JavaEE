package thread;

class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello thread");
            // 为了让这里的打印慢点, 方便看, 加个 sleep, 休眠 1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        // t.run();

        while (true) {
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
