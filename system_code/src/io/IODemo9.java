package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class IODemo9 {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("d:/test.txt")) {
            writer.write("hello world");
            // 手动刷新缓冲区
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
