package RedisWorkQueue.redisWorkQueue;

import java.util.Random;

public class Event {
   private String type;
   private ProxyPayload proxyPayload;
   private static String[] colorArr = { "red", "blue", "green", "yellow", "orange", "purple" };
   private static String[] animalArr = { "fish", "monkey", "dog", "mouse", "elephant", "duck" };

   public Event(String type) {
      this.type = type;
   }

   public void addRandomProxyPayload() {
      Random rn = new Random();

      String color = colorArr[rn.nextInt(colorArr.length)];
      String animal = colorArr[rn.nextInt(colorArr.length)];

      this.proxyPayload = new ProxyPayload(color, animal);
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public ProxyPayload getProxyPayload() {
      return proxyPayload;
   }

   public void setProxyPayload(ProxyPayload proxyPayload) {
      this.proxyPayload = proxyPayload;
   }
}
