package old;

/**
 * ClassName: car
 * Package: old
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/14 7:54
 * Version 1.0
 */
public class Car {
    private Framework framework;

    public Car(int size) {
        framework = new Framework(size);
    }

    public void init() {
        System.out.println("执行了汽车初始化方法");
        //依赖车身
        framework.init();
    }
}
