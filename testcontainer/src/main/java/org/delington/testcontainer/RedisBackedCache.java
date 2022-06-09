package org.delington.testcontainer;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPooled;

public class RedisBackedCache {

    JedisPooled jedis = new JedisPooled("localhost", 6379);
}
