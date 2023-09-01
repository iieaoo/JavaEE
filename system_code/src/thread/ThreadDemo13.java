package thread;

class Counter {
    public int count = 0;

    synchronized public void add() {
        synchronized (this) {
            count++;
        }
    }

    public void add2() {
        count++;
    }
}

public class ThreadDemo13 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // 搞两个线程, 两个线程分别针对 counter 来 调用 5w 次的 add 方法
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.add();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.add2();
            }
        });
        // 启动线程
        t1.start();
        t2.start();

        // 等待两个线程结束
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印最终的 count 值
        System.out.println("count = " + counter.count);
    }
}
