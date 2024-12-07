import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Q6Test {
    private Q6 task;

    @BeforeEach
    void setUp() {
        task = new Q6();
    }

    @AfterEach
    void tearDown() {
        task = null;
    }

    @Test
    void add() {
        int result = task.add(2,3);
        assertEquals(5,result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 3, 8",
            "-1, -1, -2 ",
            "0, 0, 0",
            "100, 200, 300"
    })
    void testAddWithCsvSource(int a, int b, int expected){
        int result = task.add(a,b);
        assertEquals(expected,result);
    }
}