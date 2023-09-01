package thread;

import java.util.concurrent.Semaphore;

public class ThreadDemo31 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        semaphore.acquire();
        System.out.println("执行一次 P 操作");
        semaphore.acquire();
        System.out.println("执行一次 P 操作");
        semaphore.acquire();
        System.out.println("执行一次 P 操作");
        semaphore.acquire();
        System.out.println("执行一次 P 操作");

        semaphore.release();
    }
}
