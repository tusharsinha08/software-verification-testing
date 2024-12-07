import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q2_3Test {
    Q2 calculator;

    @BeforeEach
    void setUp() {
        System.out.println("Start");
        calculator = new Q2();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finish");
        calculator = null;
    }

    @Test
    void add() {
        assertEquals(5,calculator.add(2,3));
        assertNotEquals(6,calculator.add(2,3));
    }

    @Test
    void divide() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5,0));
        assertDoesNotThrow(() -> calculator.divide(5,1));
    }
}
