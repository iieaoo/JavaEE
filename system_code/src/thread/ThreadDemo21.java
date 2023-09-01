package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// 阻塞队列的使用
public class ThreadDemo21 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.put("hello");
        String res = blockingQueue.take();
        System.out.println(res);
        res = blockingQueue.take();
        System.out.println(res);

    }
}
