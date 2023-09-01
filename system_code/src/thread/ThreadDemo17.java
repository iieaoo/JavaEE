package thread;

public class ThreadDemo17 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();

        Thread t1 = new Thread(() -> {
            // 这个线程负责进行等待
            System.out.println("t1: wait 之前");
            try {
                synchronized (object) {
                    object.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1: wait 之后");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2: notify 之前");
            synchronized (object) {
                // notify 务必要获取到锁, 才能进行通知
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                object.notify();
            }
            System.out.println("t2: notify 之后");
        });

        t1.start();
        // 此处写的 sleep 500 是大概率会让当前的 t1 先执行 wait 的.
        // 极端情况下 (电脑特别卡的时候, 就像老湿现在), 可能线程的调度时间就超过了 500 ms
        // 还是可能 t2 先执行 notify.
        Thread.sleep(500);
        t2.start();
    }
}
