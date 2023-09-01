package ioc;

/**
 * ClassName: App
 * Package: ioc
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/14 11:02
 * Version 1.0
 */
public class App {
    public static void main(String[] args) {
        Tire tire = new Tire(30,"red");
        Bottom bottom = new Bottom(tire);
        Framework framework = new Framework(bottom);
        Car car = new Car(framework);
        car.init();
    }
}
