package org.example.homework2_ToadBundy;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
@Slf4j
public class Main {

    public static void main(String[] args) {
        PhoneType phoneType = new PhoneType("Motorolla", "2235", true);
        System.out.println(phoneType);

        PhoneDto phoneDto = PhoneDto.builder()
                .number("125")
                .phoneType(phoneType)
                .clientFio("Toad Bundy")
                .isGovernment(false)
                .build();
        System.out.println(phoneDto);
        logging();
    }

    public static void logging(){
        log.error("Критическая ошибка системы");
        log.info("Информация по клиенту: \"Петров Иван Иванович, сумма на счете 1_000_000 рублей\"");
        log.trace("Обращение в интеграцию сервиса \"Мой Мир\"");
        log.warn("Клиент не найден, операция не может быть обработана");
        log.debug("Значение переменной firstLevel");
    }

    public static void runExceptions() throws Exception {
        throw new Exception("Опачки");
    }

    public static void runExceptions2(){
        try{
            throw new RuntimeException("Опачки");
        }catch(RuntimeException e){

        }
    }

    @SneakyThrows
    public static void runExeptions3(){
        throw new Exception("Опачки");
    }

    @SneakyThrows
    public static void MyGame(){
        @Cleanup FileWriter writer = new FileWriter("1.txt");
    }
}
