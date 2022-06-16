package org.delington.testcontainer.redis;

public interface RedisClient {

    void put(String key, String value);

    String get(String key);
}
