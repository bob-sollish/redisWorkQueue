package RedisWorkQueue.redisWorkQueue;

import java.util.Random;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

public class WorkEventProducer {
   private static String[] eventTypeArr = { "eventType1", "eventType2", "eventType3" };
   private static Gson gson = new Gson();
   private static Jedis jedis = new Jedis("localhost");
   private static String workQueueName = "workQueue";

   public static void main(String[] args) throws InterruptedException {
      System.out.println("I am the WorkEventProducer!");

      Random rn = new Random();
      int count = 0;
      int limit = 10;
      int minPauseMs = 500;
      int maxPauseMs = 3000;

      while (count < limit) {
         // random pause
         Thread.sleep((long) (Math.random() * (maxPauseMs - minPauseMs)) + minPauseMs);

         String randomEventType = eventTypeArr[rn.nextInt(eventTypeArr.length)];
         WorkEvent we = new WorkEvent(randomEventType);
         we.addRandomProxyPayload();
         addToWorkQueue(we);
         count++;
      }

      System.out.println("(Bye!)");

      jedis.close();
   }

   private static void addToWorkQueue(WorkEvent we) {
      String value = gson.toJson(we);

      System.out.println("Adding: " + value + " to WorkQueue");

      jedis.rpush(workQueueName, value);
   }
}
