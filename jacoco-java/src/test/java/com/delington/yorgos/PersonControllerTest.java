package com.delington.yorgos;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonControllerTest {

    private final PersonController controller = new PersonController();

    @Test
    public void sampleTest() {
        final String EXPECTED_TEXT = "index";
        final var controllerResponse = controller.sample();

        Assertions.assertThat(controllerResponse).contains(EXPECTED_TEXT);
    }
}
