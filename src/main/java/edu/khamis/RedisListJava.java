package edu.khamis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisListJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("https://localhost:6379");
        System.out.println("Connection to server successfully");

        //store data in redis list
        jedis.lpush("Topics", "Cassandra");
        jedis.lpush("Topics", "Redis");
        jedis.lpush("Topics", "Mongodb");

        // Get the stored data and print it
        List<String> list = jedis.lrange("Topics", 0, 5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Stored string in redis:: " + list.get(i));
        }
    }
}