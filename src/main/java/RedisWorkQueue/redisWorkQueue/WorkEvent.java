package RedisWorkQueue.redisWorkQueue;

public class WorkEvent extends Event {
   private int retryCount = 0;

   public WorkEvent(String type) {
      super(type);
      // TODO Auto-generated constructor stub
   }
}
