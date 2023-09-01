package thread;

// 使用匿名内部类来创建线程
public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        t.start();
    }
}
