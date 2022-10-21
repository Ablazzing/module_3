package maven_tutorial;

import org.example.module_3.lesson3.Calc;
import org.junit.Test;

public class CalcTest {

    @Test

    public void myFirstTest() {
        int result = Calc.addNumbers(1, 2);
        if (result != 3) {
            throw new RuntimeException("Ошибка! Результат не соответствует ожидаемому!");
        }

    }
}
