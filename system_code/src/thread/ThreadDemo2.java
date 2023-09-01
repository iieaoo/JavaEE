package thread;

// Runnable 作用, 是描述一个 "要执行的任务" , run 方法就是任务的执行细节
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hello thread");
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        // 这只是描述了个任务
        Runnable runnable = new MyRunnable();
        // 把任务交给线程来执行
        Thread t = new Thread(runnable);
        t.start();
    }
}
