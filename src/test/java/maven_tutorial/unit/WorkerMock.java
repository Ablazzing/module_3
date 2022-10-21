package maven_tutorial.unit;

import org.example.module_3.lesson3.Wheel;
import org.example.module_3.lesson3.Worker;

public class WorkerMock extends Worker {
    @Override
    public boolean makeCar() {
        return false;
    }

    @Override
    public Wheel createWheel(int radius) {
        if (radius == 17) {
            return new Wheel(17);
        }
        return null;
    }
}
