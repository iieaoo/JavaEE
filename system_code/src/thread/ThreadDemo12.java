package thread;

// 通过这个代码来演示, 多线程和单线程相比, 效率的提升.
public class ThreadDemo12 {
    public static void main(String[] args) {
        // 假设当前有两个变量, 需要把两个变量各自自增 1000w 次. (典型的 CPU 密集型的场景)
        // 可以一个线程, 先针对 a 自增, 然后再针对 b 自增
        // 还可以两个线程, 分别对 a 和 b 自增.

        // serial();
        concurrency();
    }

    // 串行执行, 一个线程完成
    public static void serial() {
        // 为了衡量带没带的执行速度, 加上个计时的操作
        // currentTimeMillis 获取到当前系统的 ms 级时间戳.
        long beg = System.currentTimeMillis();

        long a = 0;
        for (long i = 0; i < 100_0000_0000L; i++) {
            a++;
        }
        long b = 0;
        for (long i = 0; i < 100_0000_0000L; i++) {
            b++;
        }

        long end = System.currentTimeMillis();
        System.out.println("执行时间: " + (end - beg) + " ms");
    }

    public static void concurrency() {
        // 使用两个线程分别完成自增.
        Thread t1 = new Thread(() -> {
            long a = 0;
            for(long i = 0; i < 100_0000_0000L; i++) {
                a++;
            }
        });
        Thread t2 = new Thread(() -> {
            long b = 0;
            for(long i = 0; i < 100_0000_0000L; i++) {
                b++;
            }
        });
        // 开始计时
        long beg = System.currentTimeMillis();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 结束计时
        long end = System.currentTimeMillis();
        System.out.println("并发执行时间: " + (end - beg) + " ms");
    }
}
