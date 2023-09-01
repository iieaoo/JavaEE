package ioc;

/**
 * ClassName: Car
 * Package: ioc
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/14 10:30
 * Version 1.0
 */
public class Car {
    private Framework framework;

    public Car(Framework framework) {
        this.framework = framework;
    }

    public void init() {
        System.out.println("执行 Car");
        // 依赖本身
        framework.init();;
    }
}
