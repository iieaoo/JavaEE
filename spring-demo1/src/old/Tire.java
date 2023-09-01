package old;

/**
 * ClassName: Tire
 * Package: old
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/14 8:06
 * Version 1.0
 */
public class Tire {
    private int size = 20;

    public Tire(int size) {
        this.size = size;
    }

    public void init() {
        System.out.println("执行了轮胎初始化方法，size: "+ this.size);
    }
}
