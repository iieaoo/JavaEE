package io;

import java.io.File;

public class IODemo4 {
    public static void main(String[] args) {
        File dir = new File("./test/aaa/bbb/");
        // mkdir 只能创建一级目录
        // mkdirs 才能创建多级目录
        dir.mkdirs();
    }
}
