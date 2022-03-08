import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeConverterTest {

    @ParameterizedTest
    @CsvSource({"12:00:00AM,00:00:00,hh:mm:ssa,HH:mm:ss", "12:00:00AM,12:00:00,hh:mm:ssa,hh:mm:ss"})
    void timeConversion(String inputTime, String expectedFormattedTime, String readPattern, String targetPattern) {

        final var formattedDate = TimeConverter.timeConversion(inputTime, readPattern, targetPattern);
        assertEquals(expectedFormattedTime, formattedDate);
    }
}