package maven_tutorial.integration;

import lombok.SneakyThrows;
import org.example.module_3.lesson7.homework.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BrickFactoryIT {

    //1. Создать работника уставшего и проверить неработоспособность BrickFactory
    @Test
    @DisplayName("Работоспособность с уставшим работником")
    public void firstIntegrationTest() {
        Worker tiredWorker = new Worker(true);
        BrickFactory brickFactory = new BrickFactory(tiredWorker, 10_000, 10_000);
        Assert.assertThrows(WorkerTiredException.class, brickFactory::createBrick);
    }

    //2. Создать неуставшего работника и BrickFactory с 100л воды и 500 кг песка, написать тест ожидающий ошибку
    @Test
    @DisplayName("Получение ошибки нехватки ресурсов")
    public void secondIntegrationTest() {
        Worker untiredWorker = new Worker(false);
        BrickFactory brickFactory = new BrickFactory(untiredWorker, 500, 100);
        Assert.assertThrows(NotEnoughResourcesException.class, brickFactory::createBrick);
    }

    //3. Создать неуставшего работника и BrickFactory с 2000л воды и 2000 кг песка, необходимо получить два кирпича
    @SneakyThrows
    @Test
    @DisplayName("Получение 2 кирпичей из 2000л воды и 2000кг песка")
    public void thirdIntegrationTest() {
        Worker untiredWorker = new Worker(false);
        BrickFactory brickFactory = new BrickFactory(untiredWorker, 2_000, 2_000);
        int expected = 2;
        List<Brick> bricksCount = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Brick brick = brickFactory.createBrick();
            bricksCount.add(brick);
        }
        int actual = bricksCount.size();
        Assertions.assertEquals(expected, actual);
    }
}
