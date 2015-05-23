import java.util.*;

public class ComplexNumberMain {
   
	public static void main(String[] args) {
		ComplexNumber c = new ComplexNumber(0, 2);
<<<<<<< HEAD
		c.printPolar();
		Queue<ComplexNumber> numbers = c.findRoots(5);
		ComplexNumber x = numbers.remove();
		x.printCartesian();
		numbers.remove().printCartesian();
		numbers.remove().printCartesian();
		numbers.remove().printCartesian();
		numbers.remove().printCartesian();
=======
		c.printP();
		Queue<ComplexNumber> numbers = c.findRoot(3);
		ComplexNumber x = numbers.remove();
		x.printC();
		x.printP();
		x.compareTo(c);
		numbers.remove().printC();
		numbers.remove().printC();
>>>>>>> 82e6bf021fbae380c63d4b98598c03ebffa68a09
		System.out.print(1/5.0);
	}
}