package com.delington.testcontainer;

import org.delington.testcontainer.RedisBackedCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedisBackedCacheIntTest {

    private static final int REDIS_PORT = 6379;
    private static final String REDIS_TEST_CONTAINER_VERSION = "redis:5.0.3-alpine";

    private RedisBackedCache underTest;

    @Container
    public GenericContainer redis = new GenericContainer(DockerImageName.parse(REDIS_TEST_CONTAINER_VERSION))
            .withExposedPorts(REDIS_PORT);

    @BeforeEach
    public void setUp() {
        // Assume that we have Redis running locally?
        underTest = new RedisBackedCache("localhost", REDIS_PORT);
    }

    @Test
    public void testSimplePutAndGet() {
        underTest.put("test", "example");

        String retrieved = underTest.get("test");
        assertEquals("example", retrieved);
    }
}
