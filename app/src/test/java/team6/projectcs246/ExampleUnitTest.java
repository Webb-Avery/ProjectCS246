package team6.projectcs246;

import org.junit.Test;
import java.util.regex.Pattern;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        // Sample test
    }

    @Test
    public void login_IsCorrect() {
        assertThat(Login.signInWithEmailAndPassword("email","password"));
    }

    @Test
    public void userName_IsCorrect() {
        assertThat(Login.askUserName(),true);
    }

    @Test
    public void created_IsCorrect() {
        assertThat(Login.createUserWithEmailAndPassword("email","password"));
    }
}