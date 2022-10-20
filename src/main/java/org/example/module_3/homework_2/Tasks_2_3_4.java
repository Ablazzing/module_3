package org.example.module_3.homework_2;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;

@Slf4j
public class Tasks_2_3_4 {
    public static void main(String[] args) {
        //Задача №2
        //Даны методы runExceptions. Сделать так, чтобы (код можно раскомментировать):
        //Первый метод выкидывал проверяемое исключение
        //Второй метод внутри себя выбрасывал непроверяемое исключение, но обрабатывал его
        //Третий метод выкидывал проверяемое исключение, но не содержал в сигнатуре метода этот тип ошибки

        //runExceptions();
        runExceptions2();
        //runExceptions3();

        //Задача №3
        //Сделать в методе myGame так, чтобы writer закрывался, не писав при этом метод close.
        //Проверяемые ошибки должны быть проигнорированы
        myGame();

        //Задача №4
        //дано пять ситуаций:
        //1. Критическая ошибка системы
        //2. Информация по клиенту: "Петров Иван Иванович, сумма на счете 1_000_000 рублей"
        //3. Обращение в интеграцию сервиса "Мой Мир"
        //4. Клиент не найден, операция не может быть обработана
        //5. Значение переменной firstLevel
        //Написать метод logging, который залогирует все эти операции по нужным уровням логирования.
        logging("Критическая ошибка системы");

    }

    public static void runExceptions() throws Exception {
        throw new Exception("Опачки");
    }

    public static void runExceptions2() {
        try {
            throw new RuntimeException("Опачки: лови RunTime Exception");
        } catch (RuntimeException e) {
            System.out.println("Всё норм пацаны, работаем дальше )");
        }
    }

    @SneakyThrows
    public static void runExceptions3() {
        throw new Exception("Опачки");
    }

    @SneakyThrows
    public static void myGame() {
        @Cleanup FileWriter writer = new FileWriter("1.txt");
    }

    public static void logging(String event) {
        switch (event) {
            case ("Критическая ошибка системы"):
                log.error(event);
                break;
            case ("Информация по клиенту: \"Петров Иван Иванович, сумма на счете 1_000_000 рублей\""):
                log.info(event);
                break;
            case ("Обращение в интеграцию сервиса \"Мой Мир\""):
                log.debug(event);
                break;
            case ("Клиент не найден, операция не может быть обработана"):
                log.warn(event);
                break;
            case ("Значение переменной firstLevel"):
                log.trace(event);
                break;
        }

    }
}
