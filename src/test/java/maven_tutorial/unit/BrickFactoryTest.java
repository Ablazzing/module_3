package maven_tutorial.unit;

import lombok.SneakyThrows;
import org.example.module_3.lesson7.homework.Brick;
import org.example.module_3.lesson7.homework.BrickFactory;
import org.example.module_3.lesson7.homework.Worker;
import org.example.module_3.lesson7.homework.WorkerTiredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

public class BrickFactoryTest {
    Worker workerMock = Mockito.mock(Worker.class);
    @Test
    @DisplayName("Ожидание ошибки у BrickFactory")
    @SneakyThrows
    public void factoryExceptionTest() {
        Mockito.when(workerMock.createBrick()).thenThrow(WorkerTiredException.class);
        BrickFactory brickFactory = new BrickFactory(workerMock, 1000, 1000);
        Assertions.assertThrows(WorkerTiredException.class, brickFactory::createBrick);
    }

    @Test
    @DisplayName("Наличие и отсутствие работника на фабрике")
    public void checkFactoryHasWorkerTest() {
        BrickFactory brickFactory1 = new BrickFactory(workerMock, 1000, 1000);
        BrickFactory brickFactory2 = new BrickFactory(null, 1000, 1000);

        boolean actualTrue = brickFactory1.checkFactoryHasWorker();
        boolean expectedTrue = true;
        Assertions.assertEquals(expectedTrue, actualTrue);

        boolean actualFalse = brickFactory2.checkFactoryHasWorker();
        boolean expectedFalse = false;
        Assertions.assertEquals(expectedFalse, actualFalse);
    }

    @Test
    @DisplayName("Создание партии 10 кирпичей")
    @SneakyThrows
    public void createBricks() {
        BrickFactory brickFactory = new BrickFactory(workerMock, 10_000, 10_000);
        int actual = 0;
        for (int i = 0; i < 10; i++) {
            Brick brick = brickFactory.createBrick();
            actual++;
        }
        int expected = 10;
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Создание разных партий")
    @CsvFileSource(resources = "/factory_sources.csv", delimiter = ';')
    @SneakyThrows
    public void paramTest(Integer sand, Integer water, Integer expected) {
        Worker workerMock = Mockito.mock(Worker.class);
        BrickFactory brickFactory = new BrickFactory(workerMock, sand, water);
        Integer actual = 0;
        for (int i = 0; i < expected; i++) {
            Brick brick = brickFactory.createBrick();
            actual++;
        }
        Assertions.assertEquals(expected, actual);
    }

}
