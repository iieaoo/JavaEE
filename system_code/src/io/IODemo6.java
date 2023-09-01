package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IODemo6 {
    // 使用一下字节流来读取文件.
    public static void main(String[] args) throws IOException {
        // 创建 InputStream 对象的时候, 使用绝对路径或者相对路径, 都是可以的. 也可以使用 File 对象.
        InputStream inputStream = new FileInputStream("d:/cat.jpg");

        // 进行读操作.
//        while (true) {
//            int b = inputStream.read();
//            if (b == -1) {
//                // 读取完毕
//                break;
//            }
//            System.out.printf("%x\n", (byte)b);
//        }

        while (true) {
            byte[] buffer = new byte[1024];
            int len = inputStream.read(buffer);
            System.out.println("len: " + len);
            if (len == -1) {
                break;
            }
            // 此时读取的结果就被放到了 byte 数组中.
//            for (int i = 0; i < len; i++) {
//                System.out.printf("%x\n", buffer[i]);
//            }
        }

        inputStream.close();
    }
}
