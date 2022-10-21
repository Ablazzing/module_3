package maven_tutorial;

import org.example.module_3.lesson5.Redactor;

public class RedactorMock extends Redactor {

    @Override
    public String getLowerCaseText(String text) {
        if (text.equals("people")) {
            return "PEOPLE";
        } else if (text.equals("hello peolple")) {
            return "HELLO PEOLPLE";
        }
        return null;
    }

    @Override
    public String getUpperCaseText(String text) {
        return null;
    }
}
