package edu.khamis;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RedisKeyJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("https://localhost:6379");
        System.out.println("Connection to server successfully");

        // Get the stored data and print it
        Set<String> set = jedis.keys("*");
        List<String> list = new ArrayList<>(set);
        for(int i = 0; i<list.size(); i++) {
            System.out.println("List of stored keys:: "+list.get(i));
        }
    }
}