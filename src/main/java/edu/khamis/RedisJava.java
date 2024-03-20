package edu.khamis;

import redis.clients.jedis.Jedis;

public class RedisJava {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Jedis jedis = new Jedis("https://localhost:6379");

        System.out.println("Server is running: "+jedis.ping());
    }
}