package old;

import com.sun.glass.ui.Size;

/**
 * ClassName: Bottom
 * Package: old
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/14 8:06
 * Version 1.0
 */
public class Bottom {
    private Tire tire;

    public Bottom(int size) {
        tire = new Tire(size);
    }

    public void init() {
        System.out.println("执行了底盘初始化方法");
        //依赖轮胎
        tire.init();;
    }
}
