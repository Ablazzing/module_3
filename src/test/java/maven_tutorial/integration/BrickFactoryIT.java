package maven_tutorial.integration;

import lombok.SneakyThrows;
import org.example.module_3.lesson7.homework.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BrickFactoryIT {
    @Test
    @DisplayName("Тест с уставшим работником")
    public void tiredWorker() {
        Worker worker = new Worker(true);
        BrickFactory brickFactory = new BrickFactory(worker, 1000, 1000);
        Assertions.assertThrows(WorkerTiredException.class, brickFactory::createBrick);
    }

    @Test
    @DisplayName("Тест с недостатком материалов")
    public void notEnoughSandWater() {
        Worker worker = new Worker(false);
        BrickFactory brickFactory = new BrickFactory(worker, 500, 100);
        Assertions.assertThrows(NotEnoughResourcesException.class, brickFactory::createBrick);
    }

    @Test
    @DisplayName("Тест производства партии")
    @SneakyThrows
    public void createBrick() {
        Worker worker = new Worker(false);
        BrickFactory brickFactory = new BrickFactory(worker, 2000, 2000);
        List<Brick> bricks = new ArrayList<>();
        int expected = 2;
        for (int i = 0; i < expected; i++) {
            bricks.add(brickFactory.createBrick());
        }
        Assertions.assertEquals(expected, bricks.size());
    }
}
