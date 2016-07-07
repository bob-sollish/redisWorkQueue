package RedisWorkQueue.redisWorkQueue;

import java.util.List;
import redis.clients.jedis.Jedis;

public class WorkConsumer {
   public static void main(String[] args) {
      System.out.println("I am the WorkConsumer!");

      Jedis jedis = new Jedis("localhost");
      List<String> messages = null;
      while (true) {
         System.out.println("Waiting for a message in the queue");
         messages = jedis.blpop(0, "queue");
         System.out.println("Got the message");
         System.out.println("KEY:" + messages.get(0) + " VALUE:" + messages.get(1));
         String payload = messages.get(1);
         // Do some processing with the payload
         System.out.println("Message received:" + payload);
      }

   }
}
