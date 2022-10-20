package maven_tutorial.home_work4_integration;

import lombok.SneakyThrows;
import org.example.module_3.lesson7.homework.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BrickFactoryIT {

    private BrickFactory brickFactory;

    private Worker worker;

    @Test
    @DisplayName("Проверка неработоспособности BrigFactory с уставшим работником")
    public void sanityCheckBrigFactory() {
        worker = new Worker(true);
        brickFactory = new BrickFactory(worker, 1000, 1000);
        Assertions.assertThrows(WorkerTiredException.class, () -> brickFactory.createBrick());
    }

    @Test
    @DisplayName("Ожидание ошибки BrickFactory")
    public void checkBrigFactoryException() {
        worker = new Worker(false);
        brickFactory = new BrickFactory(worker, 500, 100);
        Assertions.assertThrows(NotEnoughResourcesException.class, () -> brickFactory.createBrick());
    }

    @Test
    @DisplayName("Проверка BrigFactory")
    @SneakyThrows
    public void brigFactoryIntegrationTest() {
        worker = new Worker(false);
        brickFactory = new BrickFactory(worker, 2000, 2000);
        List<Brick> brickList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            brickList.add(brickFactory.createBrick());
        }
        int actual = brickList.size();
        int expected = 2;
        Assertions.assertEquals(expected,actual);
    }
}
