package edu.khamis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class Khamis_Twitter {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis twitterRedis = new Jedis("https://localhost:6379");
        System.out.println("Connection to server successfully");

        //store data in redis list
        twitterRedis.lpush("Costi", "This is a tweet!");
        twitterRedis.lpush("Costi", "This is cool!");
        twitterRedis.lpush("Costi", "message!");
        twitterRedis.lpush("Costi", "Hi!");

        //Get the stored data and print it
        List<String> list = twitterRedis.lrange("Costi", 0, 5);
        String name = covertToName(twitterRedis);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Stored tweet in redis ::" + name + "\t" + list.get(i));
        }
    }

    private static String covertToName(Jedis twitter){
        Set<String> name = twitter.keys("*");
        String temp = name.toString();
        int lastIndex = temp.length() - 1;
        return temp.substring(1, lastIndex);
    }
}
