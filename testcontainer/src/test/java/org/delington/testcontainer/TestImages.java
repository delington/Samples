package org.delington.testcontainer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TestImages {

    REDIS_IMAGE("redis:5.0.3-alpine");

    private final String imageName;
}
