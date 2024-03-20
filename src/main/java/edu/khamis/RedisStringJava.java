package edu.khamis;

import redis.clients.jedis.Jedis;

public class RedisStringJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("https://localhost:6379");
        System.out.println("Connection to server successfully");

        //set the data in redis string
        jedis.set("CS157C", "NoSQL Databases");
        // Get the stored data and print it
        System.out.println("Stored string in redis:: "+ jedis.get("CS157C"));
    }
}