package thread;

public class ThreadDemo10 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("join 之前");

        // 此处的 join 就是让当前的 main 线程来等待 t 线程执行结束 (等待 t 的 run 执行完)
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("join 之后");
    }
}
