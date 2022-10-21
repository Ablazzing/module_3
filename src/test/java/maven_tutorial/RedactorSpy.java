package maven_tutorial;

import org.example.module_3.lesson5.Redactor;

public class RedactorSpy extends Redactor {
    private Redactor redactor;

    public RedactorSpy(Redactor redactor) {
        this.redactor = redactor;
    }

    @Override
    public String getUpperCaseText(String text) {
        if (text.equals("people")) {
            return "PEOPLE";
        } else if (text.equals("hello peolple")) {
            return "HELLO PEOLPLE";
        }
        return redactor.getUpperCaseText(text);
    }

    @Override
    public String getLowerCaseText(String text) {
        if (text.equals("people")) {
            return "people";
        } else if (text.equals("hello peolple")) {
            return "hello peolple";
        }
        return redactor.getLowerCaseText(text);
    }
}
