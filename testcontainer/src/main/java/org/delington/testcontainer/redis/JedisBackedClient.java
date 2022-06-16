package org.delington.testcontainer.redis;

import redis.clients.jedis.JedisPooled;

public class JedisBackedClient implements RedisClient {

    JedisPooled jedis;

    public JedisBackedClient(String host, int port) {
        this.jedis = new JedisPooled(host, port);
    }

    @Override
    public void put(String key, String value){
        jedis.set(key, value);
    }

    @Override
    public String get(String key) {
        return jedis.get(key);
    }
}
