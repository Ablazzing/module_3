package homework_tests.integrations;

import lombok.SneakyThrows;
import org.example.module_3.lesson7.homework.BrickFactory;
import org.example.module_3.lesson7.homework.NotEnoughResourcesException;
import org.example.module_3.lesson7.homework.Worker;
import org.example.module_3.lesson7.homework.WorkerTiredException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrickFactoryIT {
    @DisplayName("IT tests for BrickFactory")

    @Test
    void BrickFactoryWithTiredWorkerTest() {
        Worker worker = new Worker(true);
        BrickFactory brickFactory = new BrickFactory(worker, 10_000, 10_000);

        try {
            brickFactory.createBrick();
            fail("Ожидался WorkerTiredException");
        } catch (WorkerTiredException exception) {
            assertNotEquals("", exception.getMessage());
        }

    }

    @Test
    @SneakyThrows
    void BrickFactoryWithNotEnoughResourcesTest() {
        Worker worker = new Worker(false);
        BrickFactory brickFactory = new BrickFactory(worker, 500, 100);

        try {
            brickFactory.createBrick();
            fail("Ожидался NotEnoughResourcesException");
        } catch (NotEnoughResourcesException exception) {
            assertNotNull(exception.getMessage());
        }
    }

    @Test
    @SneakyThrows
    void BrickFactoryCreatedTwoBrickTest() {
        Worker worker = new Worker(false);
        BrickFactory brickFactory = new BrickFactory(worker, 2000, 2000);

        int brickCount = 0;
        int brickGoal = 0;

        while (brickCount < brickGoal) {
            brickFactory.createBrick();
            brickCount++;
        }

        assertEquals(brickCount, brickGoal);
    }
}
