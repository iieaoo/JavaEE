package ioc;

import java.awt.*;

/**
 * ClassName: Tire
 * Package: ioc
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/14 10:33
 * Version 1.0
 */
public class Tire {
    private int size = 20;
    private  String color;

    public Tire(int size, String color) {
        this.size = size;
        this.color = color;
    }

    public void init() {
        System.out.println("轮胎——size:" + size +" | " + color);
    }
}
