import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

class Q7Test {

    private Q7 task;
    @BeforeEach
    void setUp() {
        task = new Q7();
    }

    @AfterEach
    void tearDown() {
        task = null;
    }

    @RepeatedTest(5)
    void generateRandomNumber() {
        int randomNumber = task.generateRandomNumber();

        assertTrue(randomNumber >= 1 && randomNumber <= 100,
                "The generated number " + randomNumber + "should be between 1 and 100 ");
    }

}