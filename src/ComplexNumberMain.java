import java.util.*;

public class ComplexNumberMain {
   
	public static void main(String[] args) {
		ComplexNumber c = new ComplexNumber(0, 2);
		c.printP();
		Queue<ComplexNumber> numbers = c.findRoot(3);
		ComplexNumber x = numbers.remove();
		x.printC();
		x.printP();
		x.compareTo(c);
		numbers.remove().printC();
		numbers.remove().printC();
		System.out.print(1/5.0);
	}
}