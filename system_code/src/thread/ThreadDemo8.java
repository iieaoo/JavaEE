package thread;

public class ThreadDemo8 {
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (flag) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        Thread.sleep(3000);
        // 在主线程里就可以随时通过 flag 变量的取值, 来操作 t 线程是否结束.
        flag = false;
    }
}
