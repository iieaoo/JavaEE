package io;

import java.io.File;

public class IODemo3 {
    public static void main(String[] args) {
        File file = new File("./test.txt");
        file.delete();
    }
}
