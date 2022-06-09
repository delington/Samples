package org.delington.testcontainer;

import redis.clients.jedis.JedisPooled;

public class RedisBackedCache {

    JedisPooled jedis;

    public RedisBackedCache(String host, int port) {
        this.jedis = new JedisPooled(host, port);
    }

    public void put(String key, String... members){
        jedis.sadd(key, members);
    }

    public String get(String key) {
        return jedis.get(key);
    }
}
