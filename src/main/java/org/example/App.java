package org.example;

public class App {
    public static void main(String[] args) {
        RedisMap redis = new RedisMap();
        System.out.println(redis.put("oleg", "burn"));
        redis.put("artem", "tornado");
        redis.put("mihail", "flash");
        System.out.println(redis.get("artem"));
        System.out.println(redis.get("oleg"));
        System.out.println(redis.get("mihail"));
    }
}
