package com.delington.testcontainer;

import org.delington.testcontainer.RedisBackedCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public class RedisBackedCacheIntTestStep0 {

    private RedisBackedCache underTest;

    @Container
    public GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
            .withExposedPorts(6379);


    @BeforeEach
    public void setUp() {
        // Assume that we have Redis running locally?
        underTest = new RedisBackedCache("localhost", 6379);
    }

    @Test
    public void testSimplePutAndGet() {
        underTest.put("test", "example");

        String retrieved = underTest.get("test");
        assertEquals("example", retrieved);
    }
}
