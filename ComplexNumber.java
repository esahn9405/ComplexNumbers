import java.util.*;

public class ComplexNumber implements Comparable<ComplexNumber> {
   private double x; //real part
   private double y; //imaginary part
   private double r; //magnitude
   private double a; //angle in complex graph
   
   // Initializes complex numbers
   public ComplexNumber(double x, double y) {
      this.x = x;
      this.y = y;
      this.r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
      if (x != 0) {
         this.a = Math.atan(y / x);
         if (x < 0) {
            this.a += Math.PI;
         }
      }
      else if (y != 0) {
         this.a = Math.PI/2;
         if (y < 0) {
            this.a *= -1;
         }
      }
   }
   
   // Prints cartesian form
   public void printC() {
      if (x == 0) {
         System.out.println(y + "i");
      }
      else if (y == 0) {
         System.out.println(x);
      }
      else {
         System.out.println(x + " + " + y + "i");
      }
   }
   
   // Prints polar form
   public void printP(){
      if (a == 0) {
         System.out.print(r);
      }
      else {
         System.out.println(r + "e^(" + a + "i)");
      }
   }
   
   // Prints angular form
   public void printA() {
      System.out.println(r + "(cos(" + a + ") + isin(" + a + "))");
   }
   
   // Finds complex roots of given number
   public Queue<ComplexNumber> findRoot(int root) {
      if (root < 1) {
         throw new IllegalArgumentException();
      }
      Queue<ComplexNumber> roots = new LinkedList<ComplexNumber>();
      double rootAngle = a / root;
      double addAngle = 2 * Math.PI / root;
      for (int i = 0; i < root; i++) {
         double mag = Math.pow(r, 1.0 / root);
         double newAngle = rootAngle + i * addAngle;
         roots.add(new ComplexNumber(mag * Math.cos(newAngle), mag * Math.sin(newAngle)));
      }
      return roots;
   }
   
   // Compares magnitude of complex numbers 
   public int compareTo(ComplexNumber other) { 
      if (r < other.r) {
         return -1;
      }
      else if (r == other.r) {
         return 0;
      }
      else {
         return 1;
      }
   }
}