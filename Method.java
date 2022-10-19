package org.example;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;

public class Method {
    public static void runExceptions() throws Exception {
        throw new Exception("Опачки");
    }

    public static void runExceptions2() {
        throw new RuntimeException("Опачки");
    }

    @SneakyThrows
    public static void runExceptions3() {
        throw new Exception("Опачки");

    }
    @SneakyThrows
    public static void myGame ()  {
        @Cleanup FileWriter writer = new FileWriter("txt");
       writer.write("My work");
    }
}
