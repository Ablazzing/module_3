package maven_tutorial;

import org.assertj.core.api.Assertions;
import org.example.module_3.lesson5.Notepad;
import org.example.module_3.lesson5.Redactor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

public class NotepadMockitoTest {

    @Test
    public void testCase() {
        Redactor mock = Mockito.mock(Redactor.class);
        Mockito.when(mock.getLowerCaseText("people"))
                .thenReturn("PEOPLE");
        Mockito.when(mock.getLowerCaseText("hello people"))
                .thenReturn("HELLO PEOPLE");

        Notepad notepad = new Notepad(mock);
        boolean isFind = notepad.findText("hello people", "people");

        Assertions.assertThat(isFind).isTrue();
    }
}
