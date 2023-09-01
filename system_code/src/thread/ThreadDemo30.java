package thread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo30 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        boolean result = reentrantLock.tryLock();
        try {
            if (result) {
                // 和女神吃饭 (需要考虑线程安全的操作)
            } else {
                // 啥都不做呗
            }
        } finally {
            if (result) {
                reentrantLock.unlock();
            }
        }

    }
}
