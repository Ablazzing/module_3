package org.example.module_3.lesson5;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Redactor {


    public String getUpperCaseText(String text) {
        //много кода
        return text.toUpperCase();
    }

    @SneakyThrows
    public String getLowerCaseText(String text) {
        FileWriter writer = new FileWriter("1.txt", StandardCharsets.UTF_8 ,true);
        writer.write(text + "\n");
        writer.close();
        return text.toLowerCase();
    }
}
