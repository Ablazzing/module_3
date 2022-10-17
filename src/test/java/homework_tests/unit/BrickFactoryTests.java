package homework_tests.unit;

import lombok.SneakyThrows;
import org.example.module_3.lesson7.homework.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit tests for the BrickFactory")
public class BrickFactoryTests {
    private Worker workerMock;

    @BeforeEach
    public void beforeEach() {
        workerMock = Mockito.mock(Worker.class);
    }

    @Test
    @DisplayName("WorkerExceptionInBrickFactory")
    void workerExceptionTest() throws WorkerTiredException {
        BrickFactory brickFactory = new BrickFactory(workerMock, 5000, 5000);
        Mockito.when(workerMock.createBrick()).thenThrow(WorkerTiredException.class);

        try {
            brickFactory.createBrick();
            fail("Ожидался WorkerTiredException");
        } catch (WorkerTiredException exception) {
            assertNotEquals("", exception.getMessage());
        }
    }

    @Test
    @DisplayName("TestCheckFactoryHasWorker")
    void checkFactoryHasWorkerTest() {
        BrickFactory brickFactory = new BrickFactory(workerMock, 5000, 5000);
        BrickFactory brickFactory1 = new BrickFactory(null, 5000, 5000);
        boolean actual1 = brickFactory.checkFactoryHasWorker();
        boolean actual2 = brickFactory1.checkFactoryHasWorker();

        assertTrue(actual1);
        assertFalse(actual2);
    }


    @Test
    @SneakyThrows
    @DisplayName("TestCreateBrick")
    void createBrickTest() {
        BrickFactory brickFactory = new BrickFactory(workerMock, 10_000, 10_000);

        int brickCount = 0;
        int brickGoal = 10;

        while (brickCount < brickGoal) {
            brickFactory.createBrick();
            brickCount++;
        }

        assertEquals(brickCount, brickGoal);
    }

    @ParameterizedTest
    @SneakyThrows
    @CsvFileSource(resources = "/factory_source.csv", delimiter = ';')
    void paramTestCreateBrick(int waterCount, int sandCount, int brickExpected) {
        BrickFactory brickFactory = new BrickFactory(workerMock, sandCount, waterCount);

        int brickCount = 0;

        while (brickCount < brickExpected) {
            brickFactory.createBrick();
            brickCount++;
        }

        assertEquals(brickCount, brickExpected);
    }
}
