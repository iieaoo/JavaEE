package old;

/**
 * ClassName: Framework
 * Package: old
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/14 7:55
 * Version 1.0
 */
public class Framework {
    private Bottom bottom;

    public Framework(int size) {
        bottom = new Bottom(size);
    }

    public void init() {
        System.out.println("执行了车身初始化方法");
        //依赖底盘
        bottom.init();
    }
}
