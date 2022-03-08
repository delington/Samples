import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class TimeConverter {
    /*
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String timeConversion(String inputDate, String readPattern, String targetPattern) {
        final var readTime = LocalTime.parse(inputDate, DateTimeFormatter.ofPattern(readPattern, Locale.US));
        return readTime.format(DateTimeFormatter.ofPattern(targetPattern));
    }

}
