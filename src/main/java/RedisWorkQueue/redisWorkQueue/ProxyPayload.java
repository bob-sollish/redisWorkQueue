package RedisWorkQueue.redisWorkQueue;

public class ProxyPayload {
   private String color;
   private String animal;

   public ProxyPayload(String color, String animal) {
      this.color = color;
      this.animal = animal;
   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public String getAnimal() {
      return animal;
   }

   public void setAnimal(String animal) {
      this.animal = animal;
   }
}
