package org.example.module_3;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Log {
        public static void logging () {
            int level = 4;
            log.trace("Значение переменной firstlevel");
            log.debug("Обращение в интеграцию /Мой мир/");
            log.info("Информация по клиенту : / Петров Иван Иваныч, сумма на счете 1_000_000");
            log.warn("Клиент не найден операция не может быть обработана ");
            log.error("Критическая ошибка системы");

        }
    }
