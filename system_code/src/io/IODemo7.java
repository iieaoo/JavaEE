package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IODemo7 {
    // 进行写文件
    public static void main(String[] args) throws IOException {
        try (OutputStream outputStream = new FileOutputStream("d:/test.txt")) {
            outputStream.write(97);
            outputStream.write(98);
            outputStream.write(99);
            outputStream.write(100);
        }
    }
}
