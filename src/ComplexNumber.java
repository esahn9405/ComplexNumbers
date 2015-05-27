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
	
	// Prints cartesian form
	public void printCartesian(int round) {
		if (re != 0 || im == 0) {
			System.out.print(round(re, round) + " ");
		}
		if (im < 0) {
			System.out.print("- " + -1 * round(im, round) + "i");
		}
		else if (im > 0) {
			System.out.print("+ " + round(im, round) + "i");
		}
		System.out.println();
	}
		
	public void printCartesian() {
		this.printCartesian(3);
	}

	// Prints polar form
	public void printPolar(int round) {
		System.out.print(round(mag, round));
		if (ang != 0) {
			System.out.print("e^(" + round(ang, round) + "i)");
		}
		System.out.println();
	}
	
	public void printPolar() {
		this.printPolar(3);
	}
   
	// Prints angular form
	public void printAngular(int round) {
		System.out.println(round(mag, round) + "(cos(" + round(ang, round) + ") + isin(" + round(ang, round) + "))");
	}
	
	public void printAngular() {
		this.printAngular(3);
	}
	
	//adds complexNumber
	public ComplexNumber add(ComplexNumber other) {
		return new ComplexNumber(re + other.re, im + other.im);
	}
	
	//subtracts compelxNumber
	public ComplexNumber subtract(ComplexNumber other) {
		return new ComplexNumber(re - other.re, im - other.im);
	}
	
	//multiplies complexNumber
	public ComplexNumber multiply(ComplexNumber other) {
		return new ComplexNumber(re * other.re - im * other.im, re * other.im + im * other.re);
	}
	
	//divides complexNumber
	public ComplexNumber divide(ComplexNumber other) {
		return new ComplexNumber((re * other.re + im * other.im) / other.mag, (- re * other.im + im * other.re) / other.mag );
	}
	
	//returns conjugate
	public ComplexNumber conjugate() {
		return new ComplexNumber(re, - im);
	}
	
	// Finds complex roots of given number
	public Queue<ComplexNumber> findRoots(int root) {
		if (root <= 0) {
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
	
	//round numbers
	public double round(double number, int round) {
		if (round < 0) {
			throw new IllegalArgumentException();
		}
		double precision = Math.pow(10, round);
		number = Math.round(number * precision) / precision;
		return number;
	}
}