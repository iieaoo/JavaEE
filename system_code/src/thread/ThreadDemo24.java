package thread;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadDemo24 {
    public static void main(String[] args) {
        System.out.println("程序启动!");
        // 这个 Timer 类就是标准库的定时器.
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("运行定时器任务1");
            }
        }, 3000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("运行定时器任务2");
            }
        }, 2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("运行定时器任务3");
            }
        }, 1000);
    }
}
