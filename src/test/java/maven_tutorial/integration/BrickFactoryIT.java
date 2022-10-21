package maven_tutorial.integration;

import lombok.SneakyThrows;
import org.example.module_3.lesson3.Worker;
import org.example.module_3.lesson7.homework.Brick;
import org.example.module_3.lesson7.homework.BrickFactory;
import org.example.module_3.lesson7.homework.NotEnoughResourcesException;
import org.example.module_3.lesson7.homework.WorkerTiredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BrickFactoryIT {
    @Test
    public void tiredWorkerTest() {
        Worker worker = new Worker(true);
        BrickFactory brickFactory = new BrickFactory(worker, 1000, 1000);
        Assertions.assertThrows(WorkerTiredException.class, brickFactory::createBrick);
    }

    @Test
    public void brickFactoryExceptionTest() {
        Worker worker = new Worker(false);
        BrickFactory brickFactory = new BrickFactory(worker, 500, 100);
        Assertions.assertThrows(NotEnoughResourcesException.class, brickFactory::createBrick);
    }

    @Test
    @SneakyThrows
    public void twoBricksTest() {
        Worker worker = new Worker(false);
        BrickFactory brickFactory = new BrickFactory(worker, 2000, 2000);
        List<Brick> bricks = new ArrayList<>();
        bricks.add(brickFactory.createBrick());
        bricks.add(brickFactory.createBrick());
        Assertions.assertEquals(2, bricks.size());
    }
}
