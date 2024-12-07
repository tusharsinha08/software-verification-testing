import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q4Test {

    private Q4 task;

    @BeforeEach
    void setUp() {
        task = new Q4();
    }

    @AfterEach
    void tearDown() {
        task = null;
    }

    @Test
    void getArray() {
        int[] expected = {1, 2, 3};
        int[] actual = task.getArray(new int[]{2, 3, 4});
        assertArrayEquals(expected, actual);
    }

    @Test
    void stringEqual() {
        String str1 = "Hello";
        String str2 = str1;

        assertSame(str1, str2);
    }

    @Test
    void testGenerateMulti() {
        String expected = "First\nSecond\nThird";
        String actual = task.generateMulti();

        List<String> expectedLines = Arrays.asList(expected.split("\n"));
        List<String> actualLines = Arrays.asList(actual.split("\n"));

        assertLinesMatch(expectedLines,actualLines);
    }
}
