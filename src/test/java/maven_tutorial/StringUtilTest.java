package maven_tutorial;

import org.example.module_3.lesson5.Redactor;

public class StringUtilTest {

    public static void main(String[] args) {
        Redactor redactor = new Redactor();
        //Входящие параметры
        String input = "yuri";
        //Результат выполнения программы (или куска кода)
        String actual = redactor.getUpperCaseText(input);
        //Ожидаемый результат
        String expected = "YURI";

        if (!expected.equals(actual)) {
            throw new RuntimeException("Ожидаемое не соответствует реальному");
        } else {
            System.out.println("Все ок!");
        }
    }
}
