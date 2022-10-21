package maven_tutorial.unit;

import lombok.SneakyThrows;
import org.example.module_3.lesson7.homework.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


public class BrickFactoryTest {

    //Проверить наличие ошибки у BrickFactory если работник выкидывает ошибку
    @SneakyThrows
    @Test
    @DisplayName("Проверка наличия ошибки у BrickFactory, если работник выкидывает ошибку")
    public void createBrickTest1() {
        Worker mock = Mockito.mock(Worker.class);
        Mockito.when(mock.createBrick()).thenThrow(new WorkerTiredException());
        BrickFactory brickFactory = new BrickFactory(mock, 1000, 1000);
        Assert.assertThrows(WorkerTiredException.class, brickFactory::createBrick);
    }

    //Проверить что если BrickFactory имеет работника возвращает true, и false если наборот
    @Test
    @DisplayName("Проверка возвращения true при наличии работника")
    public void factoryHasWorkerTest() {
        Worker mockWorker = Mockito.mock(Worker.class);
        BrickFactory factoryWithWorker = new BrickFactory(mockWorker, 5000, 5000);
        boolean actual = factoryWithWorker.checkFactoryHasWorker();
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("Проверка возвращения false при отсутсвии работника")
    public void factoryHasNotWorkerTest() {
        BrickFactory factoryWithoutWorker = new BrickFactory(null, 5000, 5000);
        boolean actual = factoryWithoutWorker.checkFactoryHasWorker();
        Assertions.assertFalse(actual);
    }

    //3. Проверить что создаться 10 кирпичей, при 10_000л воды и 10_000 песка.
    @SneakyThrows
    @Test
    @DisplayName("Создание 10 кирпичей из 10000л воды и 10000кг песка")
    public void createBrickTest2() {
        Worker mock = Mockito.mock(Worker.class);
        Mockito.when(mock.createBrick()).thenReturn(new Brick());
        BrickFactory brickFactory = new BrickFactory(mock, 10_000, 10_000);
        List<Brick> bricksCount = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Brick brick = brickFactory.createBrick();
            bricksCount.add(brick);
        }
        int expected = 10;
        int actual = bricksCount.size();
        Assertions.assertEquals(expected, actual);
    }

    //4. Написать параметризованный тест, который читает файл factory_sources.csv, и вставляет первые два значения
    // как количество воды и песка, а третий параметр говорит сколько кирпичей должно быть создано
    @SneakyThrows
    @ParameterizedTest
    @CsvFileSource(resources = "/factory_sources.csv", delimiter = ';')
    @DisplayName("Параметризованный тест из файла factory_sources.csv")
    public void createBrickTest3(Integer waterCount, Integer sandCount, Integer createdBricksCount) {
        Worker mock = Mockito.mock(Worker.class);
        Mockito.when(mock.createBrick()).thenReturn(new Brick());
        BrickFactory brickFactory = new BrickFactory(mock, sandCount, waterCount);
        int expected = createdBricksCount;
        int actual = 0;
        while (true) {
            try {
                brickFactory.createBrick();
                actual++;
            } catch (NotEnoughResourcesException e) {
                break;
            }
        }
        Assertions.assertEquals(expected, actual);
    }
}
