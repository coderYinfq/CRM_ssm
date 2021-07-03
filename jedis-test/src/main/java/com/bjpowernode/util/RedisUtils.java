package com.bjpowernode.util;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
    private static JedisPool pool;
    //创建线程池对象
    public static JedisPool open(String ip,int port){
        if(pool==null){
            //新建连接池的配置参数
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            //指定连接实例的最大连接数
            jedisPoolConfig.setMaxTotal(20);
            //指定一个pool最多有多少个状态为idle(空闲的)的jedis实例
            jedisPoolConfig.setMaxIdle(2);
            //设置检查项为true，表示获取的redis线程一定是可用的(不为空)
            jedisPoolConfig.setTestOnBorrow(true);

            //创建pool对象
            pool = new JedisPool(jedisPoolConfig,ip,port,6000);
        }
        return pool;
    }
    //关闭池
    public static void close(){
        if(pool!=null){
            pool.close();
        }
    }

}
