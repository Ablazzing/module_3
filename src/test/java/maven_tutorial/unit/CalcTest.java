package maven_tutorial.unit;

import lombok.SneakyThrows;
import org.example.module_3.lesson3.Calc;
import org.example.module_3.lesson3.CalcException;
import org.example.module_3.lesson3.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class CalcTest {

    @Nested
    public class AddOperations {
        @Test
        @DisplayName("Сложение калькульятором чисел 1 и 2")
        @SneakyThrows
        public void myFirstTest() {
            int inputNumberA = 1;
            int inputNumberB = 2;
            int actual = Calc.addNumbers(inputNumberA, inputNumberB);
            int expected = 3;
            Assertions.assertEquals(expected, actual);
            System.out.println("Работает");
        }

        @Test
        @DisplayName("Ожидание ошибки при сложении нулей")
        public void myExceptionTest() {
            int inputNumberA = 0;
            int inputNumberB = 0;
            Assertions.assertThrows(CalcException.class, () -> Calc.addNumbers(inputNumberA, inputNumberB));
        }
    }

    @Nested
    public class DivideOperations {
        @Test
        @DisplayName("Ожидание ошибки при делении на ноль")
        public void myExceptionTest() {
            int inputNumberA = 0;
            int inputNumberB = 0;
            Assertions.assertThrows(ArithmeticException.class, () -> Calc.divide(inputNumberA, inputNumberB));
        }
    }

//    @Test
//    @DisplayName("Сравнение пользователей")
//    public void mySecondTest() {
//        User user = new User("Petr");
//        User user2 = new User("Petr");
//        Assertions.assertEquals(user, user2);
//    }

    @ParameterizedTest
    @SneakyThrows
    @CsvFileSource(resources = "/test.csv", delimiter = ';', numLinesToSkip = 1)
    public void myParamTest(Integer a, Integer b, Integer expected) {
        Integer actual = Calc.addNumbers(a, b);
        Assertions.assertEquals(expected, actual);
        System.out.println(a);
        System.out.println(b);
        System.out.println(expected);
    }

    @ParameterizedTest
    @SneakyThrows
    @CsvSource(value = {
            "1;2;3",
            "3;4;7",
            "13;4;17"
    }, delimiter = ';')
    public void myParamTest2(Integer a, Integer b, Integer expected) {
        Integer actual = Calc.addNumbers(a, b);
        Assertions.assertEquals(expected, actual);
        System.out.println(a);
        System.out.println(b);
        System.out.println(expected);
    }
}
