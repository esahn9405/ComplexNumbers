import java.util.*;

public class ComplexNumberMain {
   
   public static void main(String[] args) {
      ComplexNumber c = new ComplexNumber(0, -2);
      c.printC();
      Queue<ComplexNumber> numbers = c.findRoot(3);
      ComplexNumber x = numbers.remove();
      x.printC();
      x.printP();
      x.compareTo(c);
      numbers.remove().printC();
      numbers.remove().printC();
   }
}