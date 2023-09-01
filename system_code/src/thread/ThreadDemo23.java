package thread;

// 自己写的阻塞队列
// 此处不考虑泛型. 直接使用 int 来表示元素类型了.
class MyBlockingQueue {
    private int[] items = new int[1000];
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    // 入队列
    public void put(int value) throws InterruptedException {
        synchronized (this) {
            while (size == items.length) {
                // 队列满了, 此时要产生阻塞.
                // return;
                this.wait();
            }
            items[tail] = value;
            tail++;
            if (tail >= items.length) {
                tail = 0;
            }
            size++;

            // 这个 notify 唤醒 take 中的 wait
            this.notify();
        }
    }

    // 出队列
    public Integer take() throws InterruptedException {
        int result = 0;
        synchronized (this) {
            while (size == 0) {
                // 队列空, 也应该阻塞.
                this.wait();
            }
            result = items[head];
            head++;
            if (head >= items.length) {
                head = 0;
            }
            size--;

            // 唤醒 put 中的 wait
            this.notify();
        }
        return result;
    }
}

public class ThreadDemo23 {
    public static void main(String[] args) throws InterruptedException {
//        MyBlockingQueue queue = new MyBlockingQueue();
//        queue.put(1);
//        queue.put(2);
//        queue.put(3);
//        queue.put(4);
//        int result = 0;
//        result = queue.take();
//        System.out.println("result = " + result);
//        result = queue.take();
//        System.out.println("result = " + result);
//        result = queue.take();
//        System.out.println("result = " + result);
//        result = queue.take();
//        System.out.println("result = " + result);

        // 再写一次生产者消费者模型的代码.
        MyBlockingQueue queue = new MyBlockingQueue();
        Thread customer = new Thread(() -> {
            while (true) {
                try {
                    int result = queue.take();
                    System.out.println("消费: " + result);

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        customer.start();

        Thread producer = new Thread(() -> {
            int count = 0;
            while (true) {
                try {
                    System.out.println("生产: " + count);
                    queue.put(count);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
    }
}
