import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReaderTest {

    public static final String INPUT_TXT_FILE = "names.txt";
    private Reader reader = new Reader();

    @Test
    void readByRelativePathByStaticClassReference() {
        final var EXPECTED_RESULT = "Amanda";

        final var result = reader.readByRelativePathByStaticClassReference(INPUT_TXT_FILE);
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void readByRelativePathByInstanceReference() {
        final var EXPECTED_RESULT = "Amanda";

        final var result = reader.readByRelativePathByInstanceReference(INPUT_TXT_FILE);
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }
}