package org.example.module_3.lesson2;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;


public class Homework {
    public static void main(String[] args) {
        //Внимание! Все домашки теперь принимаются в качестве pull request. Репозитории больше смотреть не буду :)

        //Задача №1
        //Создать класс PhoneType, сделать поля неизменяемыми. Все поля должны быть не null.
        //Подумать какую(ие) аннотацию использовать: builder, superbuilder, noargsconstructor, requiredconstructor,
        //data, value
        //поля: string name, string code, boolean isMobile
        //При выводе в String убрать поле isMobile

        //Создать класс PhoneDto.
        //Подумать какую(ие) аннотацию использовать: builder, superbuilder, noargsconstructor, requiredconstructor,
        //data, value
        //поля: string number - не null, boolean isGovernment, PhoneType phoneType - не null, string clientFio
        //При выводе в String убрать поля isGoverment, phoneType

        //Задача №2
        //Даны методы runExceptions. Сделать так, чтобы (код можно раскомментировать):
        //Первый метод выкидывал проверяемое исключение
        //Второй метод внутри себя выбрасывал непроверяемое исключение, но обрабатывал его
        //Третий метод выкидывал проверяемое исключение, но не содержал в сигнатуре метода этот тип ошибки

        //Задача №3
        //Сделать в методе myGame так, чтобы writer закрывался, не писав при этом метод close.
        //Проверяемые ошибки должны быть проигнорированы

        //Задача №4
        //дано пять ситуаций:
        //1. Критическая ошибка системы
        //2. Информация по клиенту: "Петров Иван Иванович, сумма на счете 1_000_000 рублей"
        //3. Обращение в интеграцию сервиса "Мой Мир"
        //4. Клиент не найден, операция не может быть обработана
        //5. Значение переменной firstLevel
        //Написать метод logging, который залогирует все эти операции по нужным уровням логирования.
    }

    public static void runExceptions() {
        //throw new Exception("Опачки");
        //throw new RuntimeException("Опачки");

    }

    public static void runExceptions2() {
        //throw new Exception("Опачки");
        //throw new RuntimeException("Опачки");
    }

    public static void runExceptions3() {
        //throw new Exception("Опачки");
        //throw new RuntimeException("Опачки");

    }

    public static void myGame() {
        //FileWriter writer = new FileWriter("1.txt");
    }
}
