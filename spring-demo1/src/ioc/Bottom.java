package ioc;

/**
 * ClassName: Bottom
 * Package: ioc
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/14 10:32
 * Version 1.0
 */
public class Bottom {
    private Tire tire;

    public Bottom(Tire tire) {
        this.tire = tire;
    }

    public void init() {
        System.out.println("执行Bottom");
        //依赖轮胎
        tire.init();
    }
}
