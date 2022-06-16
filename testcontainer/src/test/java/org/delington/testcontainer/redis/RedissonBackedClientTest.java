package org.delington.testcontainer.redis;

import org.delington.testcontainer.TestImages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
class RedissonBackedClientTest {

    private static final int REDIS_PORT = 6379;

    private RedissonBackedClient redissonBackedClient;

    @Container
    public GenericContainer redis = new GenericContainer(DockerImageName.parse(TestImages.REDIS_IMAGE.getImageName()))
            .withExposedPorts(REDIS_PORT);

    @BeforeEach
    public void setUp() {
        // Now we have an address and port for Redis, no matter where it is running
        final var containerAddress = redis.getHost();
        final var containerPort = redis.getFirstMappedPort();

        final String address = "redis://" + containerAddress + ":" + containerPort;
        redissonBackedClient = new RedissonBackedClient(address);
    }

    @Test
    public void testSimplePutAndGet() {
        final String TEST_KEY = "test";
        final String TEST_VALUE = "example";

        redissonBackedClient.put(TEST_KEY, TEST_VALUE);

        String retrieved = redissonBackedClient.get(TEST_KEY);
        assertEquals(TEST_VALUE, retrieved);
    }
}