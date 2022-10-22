package maven_tutorial.unit.homework4;

import lombok.SneakyThrows;
import org.example.module_3.lesson7.homework.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class BrickFactoryTest {
    @Mock
    private Worker worker;

    @Test
    @SneakyThrows
    @DisplayName("Ошибка фабрики если работник устал")
    public void workerException() {
        Mockito.when(worker.createBrick()).thenThrow(WorkerTiredException.class);
        BrickFactory brickFactory = new BrickFactory(worker, 1000, 1000);
        Assertions.assertThrows(WorkerTiredException.class, brickFactory::createBrick);
    }

    //2. Проверить что если BrickFactory имеет работника возвращает true, и false если наборот
    @Test
    @SneakyThrows
    @DisplayName("Проверка на наличие работника")
    public void hasWorker() {
        BrickFactory brickFactory = new BrickFactory(worker, 1000, 1000);
        Assertions.assertTrue(brickFactory.checkFactoryHasWorker());

        BrickFactory brickFactoryWithoutWorker = new BrickFactory(null, 1000, 1000);
        Assertions.assertFalse(brickFactoryWithoutWorker.checkFactoryHasWorker());
    }

    //3. Проверить что создаться 10 кирпичей, при 10_000л воды и 10_000 песка.
    @Test
    @SneakyThrows
    @DisplayName("Успешное создание 10 кирпичей")
    public void create10Bricks() {
        Mockito.when(worker.createBrick()).thenReturn(new Brick());
        BrickFactory brickFactory = new BrickFactory(worker, 10_001, 10_001);
        Assertions.assertAll(
                Stream.generate(() -> (Executable) brickFactory::createBrick).limit(10)
        );
        Assertions.assertThrows(NotEnoughResourcesException.class, brickFactory::createBrick);
    }

    //4. Написать параметризованный тест, который читает файл factory_sources.csv, и вставляет первые два значения
    // как количество воды и песка, а третий параметр говорит сколько кирпичей должно быть создано
    @ParameterizedTest
    @CsvFileSource(resources = "/factory_sources.csv", delimiter = ';')
    @SneakyThrows
    @DisplayName("Успешное создание кирпичей из файла")
    public void createBricksFromFile(Integer sand, Integer water, Integer expectedBricks) {
        Mockito.when(worker.createBrick()).thenReturn(new Brick());
        BrickFactory brickFactory = new BrickFactory(worker, sand, water);
        Assertions.assertAll(
                Stream.generate(() -> (Executable) brickFactory::createBrick).limit(expectedBricks)
        );
        Assertions.assertThrows(NotEnoughResourcesException.class, brickFactory::createBrick);
    }
}
