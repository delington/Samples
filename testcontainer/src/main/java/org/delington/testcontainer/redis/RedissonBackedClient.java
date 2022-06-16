package org.delington.testcontainer.redis;

import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.time.Duration;

public class RedissonBackedClient implements RedisClient {

    private static final String MY_MAP_NAME = "myMap";
    private static final int TTL_DURATION_MILLISECONDS = 1000;

    private final RedissonClient redisson;
    private final RMap<String, String> myMap;

    public RedissonBackedClient(String address) {
        Config config = new Config();
        config.useSingleServer().setAddress(address);

        redisson = Redisson.create(config);

        myMap = redisson.getMap(MY_MAP_NAME);
        myMap.expire(Duration.ofMillis(TTL_DURATION_MILLISECONDS));
    }

    @Override
    public void put(String key, String value) {
        myMap.put(key, value);
    }

    @Override
    public String get(String key) {
        return myMap.get(key);
    }
}
