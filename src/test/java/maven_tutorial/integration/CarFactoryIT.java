package maven_tutorial.integration;

import org.example.module_3.lesson3.CarFactory;
import org.example.module_3.lesson3.Wheel;
import org.example.module_3.lesson3.Worker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarFactoryIT {

    @Test
    public void myFirstIntegrationTest() {
        Worker worker = new Worker();
        CarFactory carFactory = new CarFactory(worker);
        Wheel expected = new Wheel(17);
        Wheel actual = carFactory.createWheel(17);

        Assertions.assertEquals(expected, actual);
    }
}
