package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class IODemo8 {
    // 字符流的操作
    public static void main(String[] args) {
        try (Reader reader = new FileReader("d:/test.txt")) {
            while (true) {
                int ch = reader.read();
                if (ch == -1) {
                    break;
                }
                System.out.println("" + (char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
