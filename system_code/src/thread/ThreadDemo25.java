package thread;

import java.util.concurrent.PriorityBlockingQueue;

// 使用这个类来表示一个定时器中的任务.
class MyTask implements Comparable<MyTask> {
    // 要执行的任务内容
    private Runnable runnable;
    // 任务在啥时候执行 (使用毫秒时间戳表示)
    private long time;

    public MyTask(Runnable runnable, long time) {
        this.runnable = runnable;
        this.time = time;
    }

    // 获取当前任务的时间
    public long getTime() {
        return time;
    }

    // 执行任务
    public void run() {
        runnable.run();
    }

    @Override
    public int compareTo(MyTask o) {
        // 返回 小于 0, 大于 0, 0
        // this 比 o 小, 返回 < 0
        // this 比 o 大, 返回 > 0
        // this 和 o 相同, 返回 0
        // 当前要实现的效果, 是队首元素是时间最小的任务
        // 这俩是谁减谁, 前往不要去记!!! 而是试试就知道了.
        // 要么是 this.time - o.time , 要么是 o.time - this.time
        return (int) (this.time - o.time);
    }
}

// 咱们自己写个简单的定时器.
class MyTimer {
    // 扫描线程
    private Thread t = null;

    // 有一个阻塞优先级队列, 来保存任务.
    private PriorityBlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();

    // 专门使用这个对象来进行加锁/等待通知.
    private Object locker = new Object();

    public MyTimer() {
        t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 取出队首元素, 检查看看队首元素任务是否到时间了.
                        // 如果时间没到, 就把任务塞回队列里去.
                        // 如果时间到了, 就把任务进行执行.
                        System.out.println("this2: " + this);
                        synchronized (locker) {
                            MyTask myTask = queue.take();
                            long curTime = System.currentTimeMillis();
                            if (curTime < myTask.getTime()) {
                                // 还没到点, 先不必执行
                                // 现在是 13:00, 取出来的任务是 14:00 执行
                                queue.put(myTask);
                                // 在 put 之后, 进行一个 wait
                                locker.wait(myTask.getTime() - curTime);
                            } else {
                                // 时间到了!! 执行任务!!
                                myTask.run();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

    // 指定两个参数
    // 第一个参数是 任务 内容
    // 第二个参数是 任务 在多少毫秒之后执行. 形如 1000
    public void schedule(Runnable runnable, long after) {
        // 注意这里的时间上的换算
        MyTask task = new MyTask(runnable, System.currentTimeMillis() + after);
        queue.put(task);
        System.out.println("this1: " + this);
        synchronized (locker) {
            locker.notify();
        }
    }
}

public class ThreadDemo25 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1");
            }
        }, 2000);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务2");
            }
        }, 1000);
    }
}
