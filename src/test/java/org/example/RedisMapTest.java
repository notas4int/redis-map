package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RedisMapTest {
    private RedisMap redisMap;
    private final String FIRST_LOGIN = "user1";
    private final String SECOND_LOGIN = "user2";
    private final String THIRD_LOGIN = "user3";
    private final Map<String, String> users = new HashMap<>();

    @BeforeEach
    void setUp() {
        redisMap = new RedisMap();
        users.put(FIRST_LOGIN, "Oleg");
        users.put(SECOND_LOGIN, "Nastya");
        users.put(THIRD_LOGIN, "Miha");
    }

    @AfterEach
    void cleanUp() {
        users.clear();
    }

    @Test
    void put_Successfully() {
        assertEquals("OK", redisMap.put(FIRST_LOGIN, users.get(FIRST_LOGIN)));
        assertEquals("OK", redisMap.put(SECOND_LOGIN, users.get(SECOND_LOGIN)));
        assertEquals("OK", redisMap.put(THIRD_LOGIN, users.get(THIRD_LOGIN)));
    }

    @Test
    void update_Successfully() {
        String changedName = "Vova";
        redisMap.put(FIRST_LOGIN, users.get(FIRST_LOGIN));
        redisMap.put(FIRST_LOGIN, changedName);
        assertEquals(changedName, redisMap.get(FIRST_LOGIN));
    }

    @Test
    void get_Seccesfully() {
        redisMap.put(FIRST_LOGIN, users.get(FIRST_LOGIN));
        redisMap.put(SECOND_LOGIN, users.get(SECOND_LOGIN));
        redisMap.put(THIRD_LOGIN, users.get(THIRD_LOGIN));

        assertEquals(users.get(FIRST_LOGIN), redisMap.get(FIRST_LOGIN));
        assertEquals(users.get(SECOND_LOGIN), redisMap.get(SECOND_LOGIN));
        assertEquals(users.get(THIRD_LOGIN), redisMap.get(THIRD_LOGIN));
    }
}