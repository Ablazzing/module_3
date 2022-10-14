package org.example.module_3.lesson2.homework.dmitriy.k;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;

@Slf4j
public class Tasks {
    public static void main(String[] args) throws Exception {
        // runExceptions();
        runExceptions2();
        // runExceptions3();
        myGame();
        logging();
    }

    //Задача №2
    //Даны методы runExceptions. Сделать так, чтобы (код можно раскомментировать):
    //Первый метод выкидывал проверяемое исключение
    //Второй метод внутри себя выбрасывал непроверяемое исключение, но обрабатывал его
    //Третий метод выкидывал проверяемое исключение, но не содержал в сигнатуре метода этот тип ошибки

    public static void runExceptions() throws Exception {
        throw new Exception("Опачки");
    }

    public static void runExceptions2() {
        try {
            throw new RuntimeException("Опачки");
        } catch (RuntimeException e) {
            System.out.println("everything is fine");
        }
    }

    @SneakyThrows
    public static void runExceptions3() {
        throw new Exception("Опачки");
    }

    //Задача №3
    //Сделать в методе myGame так, чтобы writer закрывался, не писав при этом метод close.
    //Проверяемые ошибки должны быть проигнорированы

    @SneakyThrows
    public static void myGame() {
        @Cleanup FileWriter writer = new FileWriter("1.txt");
    }

    //Задача №4
    //дано пять ситуаций:
    //1. Критическая ошибка системы
    //2. Информация по клиенту: "Петров Иван Иванович, сумма на счете 1_000_000 рублей"
    //3. Обращение в интеграцию сервиса "Мой Мир"
    //4. Клиент не найден, операция не может быть обработана
    //5. Значение переменной firstLevel
    //Написать метод logging, который залогирует все эти операции по нужным уровням логирования.

    public static void logging() {
        log.error("Критическая ошибка");
        log.info("Петров Иван Иванович, сумма на счете 1_000_000 рублей");
        log.debug("Обращение в интеграцию сервиса \"Мой Мир\"");
        log.warn("Клиент не найден, операция не может быть обработана");
        log.trace("Значение переменной firstLevel");
    }
}
