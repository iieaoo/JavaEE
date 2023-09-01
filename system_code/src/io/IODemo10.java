package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class IODemo10 {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = new FileInputStream("d:/test.txt")) {
            Scanner scanner = new Scanner(inputStream);

            // 此时读取的内容就是从 文件 进行读取了.
            scanner.next();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
