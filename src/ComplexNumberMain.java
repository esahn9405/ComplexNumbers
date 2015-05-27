import java.util.*;

public class ComplexNumberMain {
   
	public static void main(String[] args) {
		ComplexNumber c = new ComplexNumber(0, 2);
		c.printPolar();
		Queue<ComplexNumber> numbers = c.findRoots(5);
		ComplexNumber x = numbers.remove();
		x.printCartesian();
		numbers.remove().printCartesian();
		numbers.remove().printCartesian();
		numbers.remove().printCartesian();
		ComplexNumber b = numbers.remove();
		b.printCartesian();
		ComplexNumber a = c.multiply(b);
		a.printCartesian();
	}
}