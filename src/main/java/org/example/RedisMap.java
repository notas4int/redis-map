package org.example;

import org.example.exceptions.JedisConnectionException;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisException;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class RedisMap implements Map<String, String> {
    private final JedisPool jedisPool;

    public RedisMap() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setBlockWhenExhausted(true);

        jedisPool = new JedisPool(poolConfig, "localhost", 6379);
    }

    @Override
    public String get(Object key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get((String) key);
        } catch (JedisException e) {
            throw new JedisConnectionException();
        }
    }

    @Override
    public String put(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.set(key, value);
        } catch (JedisException e) {
            throw new JedisConnectionException();
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public String remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<String> values() {
        return null;
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return null;
    }
}
