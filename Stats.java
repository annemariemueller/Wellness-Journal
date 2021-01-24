// Created by Annemarie Mueller 1/23/2021
// Represents the 3 categories of calories, hours of sleep, and glasses of water

public class Stats {
   // Fields
   int current;
   int target;
   
   // Constructor
   public Stats(int target) {
      current = 0;
      this.target = target;
   }
   
   // Methods
   public void increase(int amount) {
      current += amount;
   }
   public void decrease(int amount) {
      current -= amount;
   }
   public int getRating() {
      // too low
      if(current < target)
         return -1;
      // too high
      if(current > target) 
         return 1;
      // good
      return 0;
   }
   public int getCurrent() {
      return current;
   }
}