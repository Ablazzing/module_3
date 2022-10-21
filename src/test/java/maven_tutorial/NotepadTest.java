package maven_tutorial;

import org.example.module_3.lesson5.Notepad;
import org.example.module_3.lesson5.Redactor;

public class NotepadTest {

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    public static void testCase1() {
        Redactor redactor = new Redactor();
        Notepad notepad = new Notepad(new RedactorSpy(redactor));
        String inputSrc = "hello peolple";
        String inputRegex = "people";
        boolean actual = notepad.findText(inputSrc, inputRegex);
        boolean expected = false;

        if (actual != expected) {
            throw new RuntimeException("Не соответствие");
        }
    }

    public static void testCase2() {
        Redactor redactor = new Redactor();
        Notepad notepad = new Notepad(new RedactorSpy(redactor));
        String inputSrc = "ola la";
        String inputRegex = "la";
        boolean actual = notepad.findText(inputSrc, inputRegex);
        boolean expected = true;

        if (actual != expected) {
            throw new RuntimeException("Не соответствие");
        }
    }


}
