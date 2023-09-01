package thread;

public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                // 这个循环体啥都不干, 也不 sleep
                for (int j = 0; j < 10000000; j++) {
                    int a = 10;
                    a += 10;
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动之前, 获取 t 的状态, 就是 NEW 状态.
        System.out.println("start 之前: " + t.getState());

        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("t 执行中的状态: " + t.getState());
        }
        t.join();

        // 线程执行完毕之后, 就是 TERMINATED 状态
        System.out.println("t 结束之后: " + t.getState());
    }
}
