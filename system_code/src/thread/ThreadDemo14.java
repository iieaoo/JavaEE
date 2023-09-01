package thread;

public class ThreadDemo14 {
    public static void main(String[] args) {
        // 假设 jiangyou 是 1 号, cu 是 2 号, 约定先拿小的, 后拿大的.
        Object jiangyou = new Object();
        Object cu = new Object();

        Thread tanglaoshi = new Thread(() -> {
            synchronized (jiangyou) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (cu) {
                    System.out.println("汤老湿把酱油和醋都拿到了");
                }
            }
        });
        Thread shiniang = new Thread(() -> {
            synchronized (jiangyou) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (cu) {
                    System.out.println("师娘把酱油和醋都拿到了");
                }
            }
        });
        tanglaoshi.start();
        shiniang.start();
    }
}
