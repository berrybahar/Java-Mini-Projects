//class for rational numbers
public class Rational 
{
	private final int numerator;
	private final int denominator;
	
	//constructor for rational numbers
	public Rational(int numerator, int denominator)
	{
		this.numerator = numerator; 
		
		if(denominator <= 0)
			throw new IllegalArgumentException("denominator must be > 0");
		
		this.denominator = denominator;
	}
	
	//returns true if the rational number that the method applied on is greater than the rational number got as input
	public boolean greaterThan(Rational other)
	{
		if((this.numerator * other.denominator) > (other.numerator * this.denominator))
			return true;
		
		return false;
	}
	
	//returns true if the rational number that the method applied on is equal to the rational number that got as input
	public boolean equals(Rational other)
	{
		if((this.numerator * other.denominator) == (other.numerator * this.denominator))
			return true;
		
		return false;
	}
	
	//sums two rational numbers and returns it
	public Rational plus(Rational other)
	{
		return new Rational((this.numerator * other.denominator) + (this.denominator * other.numerator), this.denominator * other.denominator);
	}
	
	//deducts two rational numbers and returns it
	public Rational minus(Rational other)
	{
		return new Rational((this.numerator * other.denominator) - (this.denominator * other.numerator), this.denominator * other.denominator);
	}
	
	//multiplies two rational numbers and returns it
	public Rational multiply(Rational other)
	{
		return new Rational(this.numerator * other.numerator , this.denominator * other.denominator);
	}
	
	//divides two rational numbers and returns it
	public Rational divide(Rational other)
	{
		if(((double)other.numerator / other.denominator) == 0.0)
			throw new ArithmeticException("cannot divide by zero!");
		
		return new Rational(this.numerator * other.denominator, this.denominator * other.numerator);
	}
	
	public int getNumerator()
	{
		return numerator;
	}
	
	public int getDenominator()
	{
		return denominator;
	}
	
	@Override
	public String toString()
	{
		return numerator + "/" + denominator;
	}
	
	//returns the reduced rational number.
	public Rational reduce()
	{
		int gcd = gcd(this.numerator, this.denominator);
		
		if(gcd <= 0)
			gcd = (-1) * gcd;
		
		return new Rational(this.numerator / gcd, this.denominator / gcd);
	}
	
	//finds the gcd of numerator and denominator of a rational number by using Euclid's Algorithm
	public int gcd(int x, int y)
	{
		if(y == 0)
			return x;
		
		return gcd(y, x % y);
	}
}
