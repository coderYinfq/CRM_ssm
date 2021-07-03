package com.bjpowernode.jedis;

import com.bjpowernode.util.RedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.Set;

public class JedisPoolTest {
    public static void main(String[] args) {
        String ip = "192.168.1.7";
        int port = 6379;

        JedisPool pool = null;
        Jedis jedis = null;

        try{
            pool = RedisUtils.open(ip,port);
            jedis = pool.getResource();
            jedis.select(4);
            jedis.mset("k9","v9","k10","v10");
            /*事务*/
            Transaction transaction=jedis.multi();
            transaction.set("k7","v7");
            transaction.set("k8","v8");
            transaction.exec();

            /*查询*/
            Set<String> stringSet= jedis.keys("*");
            for(String s:stringSet){
                System.out.println(s);
            }
        }finally{
            if(jedis!=null){
                jedis.close();
            }
        }
    }

}
