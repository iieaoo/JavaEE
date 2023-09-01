package ioc;

/**
 * ClassName: Framework
 * Package: ioc
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/14 10:32
 * Version 1.0
 */
public class Framework {
    private Bottom bottom;

    public Framework(Bottom bottom) {
        this.bottom = bottom;
    }

    public void init() {
        System.out.println("执行 Framework");
        //依赖底盘
        bottom.init();
    }
}
