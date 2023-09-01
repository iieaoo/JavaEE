package io;

import java.io.File;

public class IODemo5 {
    public static void main(String[] args) {
        File file = new File("./test");
        File dest = new File("./testAAA");
        file.renameTo(dest);
    }
}
