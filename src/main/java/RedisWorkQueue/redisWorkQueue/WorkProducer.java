package RedisWorkQueue.redisWorkQueue;

import redis.clients.jedis.Jedis;

public class WorkProducer {
   public static void main(String[] args) {
      System.out.println("I am the WorkProducer!");

      Jedis jedis = new Jedis("localhost");

      jedis.rpush("queue", "Value 1");
      jedis.rpush("queue", "Value 2");
      jedis.rpush("queue", "Value 3");

      jedis.close();
   }
}
