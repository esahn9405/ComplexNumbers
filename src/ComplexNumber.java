import java.util.*;

public class ComplexNumber implements Comparable<ComplexNumber> {
	private double re; //real part
	private double im; //imaginary part
	private double mag; //magnitude
	private double ang; //angle in complex graph
   
	// Initializes complex numbers
	public ComplexNumber(double re, double im) {
		this.re = re;
		this.im = im;
		this.mag = Math.sqrt(Math.pow(re, 2) + Math.pow(im, 2));
		if (re != 0) {
			this.ang = Math.atan(im / re);
			if (re < 0) {
				this.ang += Math.PI;
			}
		}
		else if (im != 0) {
			this.ang = Math.PI/2;
			if (im < 0) {
				this.ang *= -1;
			}
		}
	}
<<<<<<< HEAD
	
	// Prints cartesian form
	public void printCartesian(int round) {
=======
   
	// Prints cartesian form
	public void printC() {
>>>>>>> 82e6bf021fbae380c63d4b98598c03ebffa68a09
		if (im == 0) {
			System.out.println(re);
		}
		else if (re == 0) {
			System.out.println(im + "i");
		}
<<<<<<< HEAD
		else if (im < 0) {
			System.out.println(round(re, round) + " - " + round(-1 * im, round) + "i");
		}
		else {
			System.out.println(round(re, round) + " + " + round(im, round) + "i");
		}
	}
	
	public void printCartesian() {
		this.printCartesian(3);
	}

	// Prints polar form
	public void printPolar(int round){
		if (ang == 0) {
			System.out.println(round(mag, round));
		}
		else {
			System.out.println(round(mag, round) + "e^(" + round(ang, round) + "i)");
		}
	}
	
	public void printPolar(){
		this.printPolar(3);
	}
   
	// Prints angular form
	public void printAngular(int round) {
		System.out.println(round(mag, round) + "(cos(" + round(ang, round) + ") + isin(" + round(ang, round) + "))");
	}
	
	public void printAngular(){
		this.printAngular(3);
	}
   
	// Finds complex roots of given number
	public Queue<ComplexNumber> findRoots(int root) {
		if (root <= 0) {
=======
		else {
			System.out.println(re + " + " + im + "i");
		}
	}

	// Prints polar form
	public void printP(){
		if (ang == 0) {
			System.out.println(mag);
		}
		else {
			System.out.println(mag + "e^(" + ang + "i)");
		}
	}
   
	// Prints angular form
	public void printA() {
		System.out.println(mag + "(cos(" + ang + ") + isin(" + ang + "))");
	}
   
	// Finds complex roots of given number
	public Queue<ComplexNumber> findRoot(int root) {
		if (root < 1) {
>>>>>>> 82e6bf021fbae380c63d4b98598c03ebffa68a09
			throw new IllegalArgumentException();
		}
		Queue<ComplexNumber> roots = new LinkedList<ComplexNumber>();
		double rootAngle = ang / root;
		double addAngle = 2 * Math.PI / root;
		for (int i = 0; i < root; i++) {
			double newMag = Math.pow(mag, 1.0 / root);
			double newAngle = rootAngle + i * addAngle;
			roots.add(new ComplexNumber(newMag * Math.cos(newAngle), newMag * Math.sin(newAngle)));
		}
		return roots;
	}
	
	// Compares magnitude of complex numbers
	public int compareTo(ComplexNumber other) {
		if (mag < other.mag) {
			return -1;
		}
		else if (mag == other.mag) {
			return 0;
		}
		else {
			return 1;
		}
	}
   
	private double round(double number, int round) {
		double precision = Math.pow(10, round);
		number = Math.round(number * precision) / precision;
		return number;
	}
}