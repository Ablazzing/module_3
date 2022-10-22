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
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class BrickFactoryTest {

    @Mock
    Worker  workerMock = Mockito.mock(Worker.class);

    @Test
    @DisplayName("Ожидание ошибки ")
    @SneakyThrows
    public void checkErrorBrickFactory() {
        BrickFactory brickFactory = new BrickFactory(workerMock, 1000, 1000);
        Mockito.when(workerMock.createBrick()).thenThrow(new WorkerTiredException());
        Assertions.assertThrows(WorkerTiredException.class, brickFactory::createBrick);
    }

    @Test
    @DisplayName("Наличие или отсутствие работника")
    public void checkWorkerExist() {
        boolean actual = new BrickFactory(null, 10, 10).checkFactoryHasWorker();
        Assertions.assertEquals(false, actual);
        boolean actual2 = new BrickFactory(workerMock, 10, 10).checkFactoryHasWorker();
        Assertions.assertEquals(true, actual2);
    }

    @Test
    @DisplayName("Создание 10 кирпичей")
    public void checkBricksNumber() throws WorkerTiredException {
        BrickFactory brickFactory = new BrickFactory(workerMock, 10000, 10000);
        List<Brick> bricks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            bricks.add(brickFactory.createBrick());
        }

        int actualBrickCount = bricks.size();
        Assertions.assertEquals(10, actualBrickCount);
    }

    @ParameterizedTest
    @DisplayName("Читаем количество")
    @CsvFileSource(resources = "/factory_sources.csv", delimiter = ',')
    @SneakyThrows
    public void paramFactoryTest(Integer sandCount, Integer waterCount, Integer expected) {
        BrickFactory brickFactory = new BrickFactory(workerMock, sandCount, waterCount);
        int actual = 0;
        int iter = sandCount >= waterCount ? waterCount / 1000 : sandCount / 1000;
        for (int i = 0; i < iter; i++) {
            brickFactory.createBrick();
            actual++;
        }
        Assertions.assertEquals(expected, actual);
    }

}
