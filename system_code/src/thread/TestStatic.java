package thread;

class A {
    public int x;
    public static int y;
}

public class TestStatic {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        // 当前 a1 和 a2 是两个实例.
        // x 作为普通属性, 是和实例相关(和对象相关), a1 和 a2 各自有各自的 x.
        a1.x = 10;
        a2.x = 20;
        System.out.println("a1.x = " + a1.x);
        System.out.println("a2.x = " + a2.x);

        // y 是 static 属性
        // a1.y 和 a2.y 是同一个变量
        a1.y = 10;
        a2.y = 20;
        System.out.println("a1.y = " + a1.y);
        System.out.println("a2.y = " + a2.y);
        System.out.println("A.y = " + A.y);
    }
}
