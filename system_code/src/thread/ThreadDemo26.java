package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 使用一下标准库的线程池
public class ThreadDemo26 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int n = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello " + n);
                }
            });
        }
    }
}
