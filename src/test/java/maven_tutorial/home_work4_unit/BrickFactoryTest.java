package maven_tutorial.home_work4_unit;

import lombok.SneakyThrows;
import org.example.module_3.lesson7.homework.Brick;
import org.example.module_3.lesson7.homework.BrickFactory;
import org.example.module_3.lesson7.homework.Worker;
import org.example.module_3.lesson7.homework.WorkerTiredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class BrickFactoryTest {

    private final Worker mockWorker = Mockito.mock(Worker.class);

    private BrickFactory brickFactory;

    @Test
    @DisplayName("Ожидание ошибки если Worker выкидывает ошибку")
    @SneakyThrows
    public void checkFactoryExceptionTest() {
        Mockito.when(mockWorker.createBrick()).thenThrow(WorkerTiredException.class);
        brickFactory = new BrickFactory(mockWorker, 12, 12);
        Assertions.assertThrows(WorkerTiredException.class, () -> mockWorker.createBrick());
    }

    @Nested
    class WorkerCheck {

        @Test
        @DisplayName("Проверка наличия работника у BrickFactory")
        public void checkWorkerBrickFactory() {
            brickFactory = new BrickFactory(mockWorker, 12, 20);
            boolean actual = brickFactory.checkFactoryHasWorker();
            boolean expected = true;
            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Проверка отсутствия работника у BrickFactory")
        public void checkWorkerAbsenceBrickFactory() {
            brickFactory = new BrickFactory(null, 12, 20);
            boolean actual = brickFactory.checkFactoryHasWorker();
            boolean expected = false;
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    class CheckBrickCreated {

        @Test
        @DisplayName("Тест создания кирпичей")
        @SneakyThrows
        public void createBrickTest() {
            Mockito.when(mockWorker.createBrick()).thenReturn(new Brick());
            List<Brick> listBrick = new ArrayList<>();
            brickFactory = new BrickFactory(mockWorker, 10000, 10000);
            for (int i = 0; i < 10; i++) {
                listBrick.add(brickFactory.createBrick());
            }
            int actual = listBrick.size();
            int expected = 10;
            Assertions.assertEquals(expected, actual);
        }

        @ParameterizedTest
        @DisplayName("Параметризированный тест, создания кирпичей")
        @CsvFileSource(resources = "/factory_sources.csv", delimiter = ';')
        @SneakyThrows
        public void createBrickParametrizedTest(Integer sandCount, Integer waterCount, Integer countBrick) {
            Mockito.when(mockWorker.createBrick()).thenReturn(new Brick());
            brickFactory = new BrickFactory(mockWorker, sandCount, waterCount);
            List<Brick> listBrick = new ArrayList<>();
            for (int i = 0; i < countBrick; i++) {
                listBrick.add(brickFactory.createBrick());
            }
            int actual = listBrick.size();
            int expected = countBrick;
            Assertions.assertEquals(expected, actual);
        }
    }
}
