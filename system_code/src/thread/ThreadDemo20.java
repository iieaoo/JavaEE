package thread;

class SingletonLazy {
    private volatile static SingletonLazy instance = null;

    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    private SingletonLazy() {}
}

public class ThreadDemo20 {
    public static void main(String[] args) {
        SingletonLazy s = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();
        System.out.println(s == s2);
    }
}
