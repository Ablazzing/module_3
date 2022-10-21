package maven_tutorial.unit;

import org.example.module_3.lesson3.CarFactory;
import org.example.module_3.lesson3.Wheel;
import org.example.module_3.lesson3.Worker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class CarFactoryTest {

    @Test
    @DisplayName("Успешное создание машины")
    public void successCreateCar() {
        Worker workerMock = Mockito.mock(Worker.class);
        Mockito.when(workerMock.makeCar()).thenReturn(true);
        CarFactory carFactory = new CarFactory(workerMock);
        boolean actual = carFactory.createCar();
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Неуспешное создание машины")
    public void failCreateCar() {
        Worker workerMock = Mockito.mock(Worker.class);
        Mockito.when(workerMock.makeCar()).thenReturn(false);
        CarFactory carFactory = new CarFactory(workerMock);
        boolean actual = carFactory.createCar();
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void createWheel() {
        Worker workerMock = Mockito.mock(Worker.class);
        Wheel expected = new Wheel(17);
        Mockito.when(workerMock.createWheel(17)).thenReturn(expected);
        CarFactory carFactory = new CarFactory(workerMock);
        Wheel actual = carFactory.createWheel(17);

        Assertions.assertEquals(expected, actual);
    }

}
