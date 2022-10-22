package maven_tutorial.integration;

import org.example.module_3.lesson7.homework.BrickFactory;
import org.example.module_3.lesson7.homework.NotEnoughResourcesException;
import org.example.module_3.lesson7.homework.Worker;
import org.example.module_3.lesson7.homework.WorkerTiredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.stream.Stream;

public class BrickFactoryIT {

    //Интеграционные тесты
    //1. Создать работника уставшего и проверить неработоспособность BrickFactory
    //2. Создать неуставшего работника и BrickFactory с 100л воды и 500 кг песка, написать тест ожидающий ошибку
    //3. Создать неуставшего работника и BrickFactory с 2000л воды и 2000 кг песка, необходимо получить два кирпича
    @Test
    @DisplayName("Получение ошибки при уставшем работнике")
    public void checkTiredWorker() {
        Worker worker = new Worker(true);
        BrickFactory brickFactory = new BrickFactory(worker, 1000, 1000);
        Assertions.assertThrows(WorkerTiredException.class, brickFactory::createBrick);
    }

    @Test
    @DisplayName("Получение ошибки при уставшем работнике")
    public void checkNotEnoughResources() {
        Worker worker = new Worker(false);
        BrickFactory brickFactory = new BrickFactory(worker, 500, 100);
        Assertions.assertThrows(NotEnoughResourcesException.class, brickFactory::createBrick);
    }

    @Test
    @DisplayName("Успешное создание двух кирпичей")
    public void create2Bricks() {
        Worker worker = new Worker(false);

        BrickFactory brickFactory = new BrickFactory(worker, 2000, 2000);
        Assertions.assertAll(
                Stream.generate(() -> (Executable) brickFactory::createBrick).limit(2)
        );
    }
}
