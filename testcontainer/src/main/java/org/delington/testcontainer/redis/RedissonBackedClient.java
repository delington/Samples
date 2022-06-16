package org.delington.testcontainer.redis;

import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonBackedClient implements RedisClient {

    private static final String MY_MAP_NAME = "myMap";
    private final RedissonClient redisson;
    private final RMap<String, String> myMap;

    public RedissonBackedClient(String address) {
        Config config = new Config();
        config.useSingleServer().setAddress(address);

        redisson = Redisson.create(config);

        myMap = redisson.getMap(MY_MAP_NAME);
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
