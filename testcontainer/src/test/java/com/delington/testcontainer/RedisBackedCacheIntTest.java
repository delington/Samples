package com.delington.testcontainer;

import org.delington.testcontainer.RedisBackedCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
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
        String address = redis.getHost();
        Integer port = redis.getFirstMappedPort();

        // Now we have an address and port for Redis, no matter where it is running
        underTest = new RedisBackedCache(address, port);
    }

    @Test
    public void testSimplePutAndGet() {
        final String TEST_KEY = "test";
        final String TEST_VALUE = "example";

        underTest.put(TEST_KEY, TEST_VALUE);

        String retrieved = underTest.get(TEST_KEY);
        assertEquals(TEST_VALUE, retrieved);
    }
}
