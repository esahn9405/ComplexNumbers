/**
 * The ComplexNumber class allows complex numbers to be computable on java
 * It not only allows algebraic computation but also finds root of the given complex number
 */
import java.util.*;

public class ComplexNumber implements Comparable<ComplexNumber> {
	private double re; //real part
	private double im; //imaginary part
	private double mag; //magnitude
	private double ang; //angle in complex graph
	
	/**
	 * Initializes complex number by taking real and imaginary part of the number as parameters
	 * The number is stored with real and imaginary part
	 * along with magnitude and the angle of the number's vector projection
	 * @param re the real part that is going to be stored
	 * @param im the imaginary part that is going to be stored
	 */
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
	
	/** 
	 * Takes integer round as a parameter and prints out the number in Cartesian form
	 * Basic format is given by real part + imaginary part * i
	 * and the each part is rounded with the given input decimal places
	 * @param round the number that sets how many decimal places that numbers will be rounded
	 * @return void
	 */
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
	
	/**
	 * Prints out the number in Cartesian form without taking any parameter
	 * The default rounding is given by up to 3 decimal places
	 * @return void
	 */
	public void printCartesian() {
		this.printCartesian(3);
	}

	/**
	 * Takes integer round as a parameter and prints out the number in polar form
	 * Basic format is given by magnitude * e^(angle * i)
	 * and the each part is rounded with the given input decimal places
	 * @param round the number that sets how many decimal places that numbers will be rounded
	 * @return void
	 */
	public void printPolar(int round) {
		System.out.print(round(mag, round));
		if (ang != 0) {
			System.out.print("e^(" + round(ang, round) + "i)");
		}
		System.out.println();
	}
	
	/**
	 * Prints out the in polar form number without taking any parameter
	 * The default rounding is given by up to 3 decimal places
	 * @return void
	 */
	public void printPolar() {
		this.printPolar(3);
	}
   
	/**
	 * Takes integer round as a parameter and prints out the number in angular form
	 * Basic format is given by magnitude * (cos(angle) + i * sin(angle))
	 * and the each part is rounded with the given input decimal places
	 * @param round the number that sets how many decimal places that numbers will be rounded
	 * @return void
	 */
	public void printAngular(int round) {
		System.out.println(round(mag, round) + "(cos(" + round(ang, round) + ") + isin(" + round(ang, round) + "))");
	}
	
	/**
	 * Prints out the in angular form number without taking any parameter
	 * The default rounding is given by up to 3 decimal places
	 * @return void
	 */
	public void printAngular() {
		this.printAngular(3);
	}
	
	/**
	 * Takes other complex number and adds to this complex number
	 * Returns the sum of the complex numbers
	 * @param other the other complex number which would be added    
	 * @return new complex number after addition
	 */
	public ComplexNumber add(ComplexNumber other) {
		return new ComplexNumber(re + other.re, im + other.im);
	}
	
	/**
	 * Takes other complex number and subtracts from this complex number
	 * Returns the resulting complex number after the subtraction
	 * @param other the other complex number which would be subtracted
	 * @return new complex number after subtraction
	 */
	public ComplexNumber subtract(ComplexNumber other) {
		return new ComplexNumber(re - other.re, im - other.im);
	}
	
	/**
	 * Takes other complex number and multiplies to this complex number
	 * Returns the multiple of the complex numbers
	 * @param other the other complex number which would be multiplied
	 * @return new complex number after multiplication
	 */
	public ComplexNumber multiply(ComplexNumber other) {
		return new ComplexNumber(re * other.re - im * other.im, re * other.im + im * other.re);
	}
	
	/**
	 * Takes other complex number and divides this complex number with the input
	 * It will rationalize the denominator by multiplying the conjugate to it
	 * Returns the resulting complex number after the division
	 * @param other the other complex number which would be divided with
	 * @return new complex number after division
	 */
	public ComplexNumber divide(ComplexNumber other) {
		double reNum = re * other.re + im * other.im; // real part of numerator
		double imNum = - re * other.im + im * other.re; // imaginary part of numerator
		double denom = Math.pow(other.mag, 2); // denominator
		return new ComplexNumber(reNum/denom, imNum/denom);
	}
	
	/**
	 * Returns conjugate of this complex number
	 * @return new complex number which is the conjugate of this
	 */
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