import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private static Stream<Arguments> celsiusToFahrenheitData() {
        return Stream.of(
                Arguments.of(0, 32),
                Arguments.of(25, 77),
                Arguments.of(-40, -40)
        );
    }
    @ParameterizedTest
    @MethodSource("celsiusToFahrenheitData")
    void testCelsiusToFahrenheit(double celsius, double expectedFahrenheit) {

        assertEquals(expectedFahrenheit, TemperatureConverter.celsiusToFahrenheit(celsius),
                0.01);
    }
    @Test
    void testCelsiusToFahrenheitBelowAbsoluteZero() {
        assertThrows(IllegalArgumentException.class,
                () -> TemperatureConverter.celsiusToFahrenheit(-274));
    }
}