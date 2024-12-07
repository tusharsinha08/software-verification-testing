import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {
    private static Stream<Arguments> gradeTestData() {
        return Stream.of(
                Arguments.of(95, "A"),
                Arguments.of(85, "B"),
                Arguments.of(75, "C"),
                Arguments.of(65, "D"),
                Arguments.of(55, "F")
        );
    }

    @ParameterizedTest
    @MethodSource("gradeTestData")
    void testGetGrade(int score, String expectedGrade) {
        assertEquals(expectedGrade, GradeCalculator.getGrade(score));
    }

    @Test
    void testGetGradeInvalidScore() {
        Exception lowScoreException = assertThrows(IllegalArgumentException.class,
                () -> GradeCalculator.getGrade(-1),
                "Expected exception for score < 0");
        assertEquals("Invaid Score", lowScoreException.getMessage());


        Exception highScoreException = assertThrows(IllegalArgumentException.class,
                () -> GradeCalculator.getGrade(101),
                "Expected exception for score > 100");
        assertEquals("Invaid Score", highScoreException.getMessage());
    }
}
