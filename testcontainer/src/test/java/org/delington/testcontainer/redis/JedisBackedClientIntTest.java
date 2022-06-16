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
public class JedisBackedClientIntTest {

    private static final int REDIS_PORT = 6379;

    private JedisBackedClient jedisClient;

    @Container
    public GenericContainer redisContainer = new GenericContainer(DockerImageName.parse(TestImages.REDIS_IMAGE.getImageName()))
            .withExposedPorts(REDIS_PORT);

    @BeforeEach
    public void setUp() {
        // Now we have an address and port for Redis, no matter where it is running
        final var containerAddress = redisContainer.getHost();
        final var containerPort = redisContainer.getFirstMappedPort();

        jedisClient = new JedisBackedClient(containerAddress, containerPort);
    }

    @Test
    public void testSimplePutAndGet() {
        final String TEST_KEY = "test";
        final String TEST_VALUE = "example";

        jedisClient.put(TEST_KEY, TEST_VALUE);

        String retrieved = jedisClient.get(TEST_KEY);
        assertEquals(TEST_VALUE, retrieved);
    }
}
