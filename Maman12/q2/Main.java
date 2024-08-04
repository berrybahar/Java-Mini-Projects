import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{
	public static void main(String [] args)
	{
		boolean legalInput = false;
		int numerator1 = 0;
		int numerator2 = 0;
		int denominator1 = 0;
		int denominator2 = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the world of the rational numbers! "
				+ "\nWe want two rational numbers from you for doing opeartions on those numbers.\n");
		
		while(legalInput == false)
		{
			try
			{
				System.out.println("Please enter the numerator for the first number:");
				numerator1 = scan.nextInt();
				System.out.println("Please enter the denominator for the first number:");
				denominator1 = scan.nextInt();
				System.out.println("Please enter the numerator for the second number:");
				numerator2 = scan.nextInt();
				System.out.println("Please enter the denominator for the second number:");
				denominator2 = scan.nextInt();
			}catch(InputMismatchException e)
			{
				throw new InputMismatchException("you should enter integer numbers as input!");
			}
			
			if(denominator1 <= 0 || denominator2 <= 0)
			{
				System.out.println("denominator of the rational numbers must be > 0\nPlease try again!\n");
			}else
			{
				legalInput = true;
			}
		}
		
		Rational rational1 = new Rational(numerator1, denominator1);
		Rational rational2 = new Rational(numerator2, denominator2);
		
		System.out.println("numerator of number one is: " + rational1.getNumerator() + " denominator of number one is: " + rational1.getDenominator() +
				"\nnumber one is: " + rational1 +
				" and after the reducement it's: " + rational1.reduce() + "\n");
		
		System.out.println("numerator of number two is: " + rational2.getNumerator() + " denominator of number two is: " + rational2.getDenominator() +
				"\nNumber two is: " + rational2 +
				" and after the reducement it's: " + rational2.reduce() + "\n");
		
		greaterThan(rational1.reduce() , rational2.reduce());
		System.out.println(rational1 + " + " + rational2 + " = " + rational1.plus(rational2).reduce() + "\n");
		System.out.println(rational1 + " - " + rational2 + " = " + rational1.minus(rational2).reduce() + "\n");
		System.out.println(rational1 + " * " + rational2 + " = " + rational1.multiply(rational2).reduce() + "\n");
		System.out.println(rational1 + " / " + rational2 + " = " + rational1.divide(rational2).reduce() + "\n");
	}
	
	public static void greaterThan(Rational rational1, Rational rational2)
	{
		if(rational1.greaterThan(rational2))
			System.out.println(rational1 + " > " + rational2 + "\n");
		else if(rational1.equals(rational2))
			System.out.println(rational1 + " = " + rational2 + "\n");
		else if(rational2.greaterThan(rational1))
			System.out.println(rational1 + " < " + rational2 + "\n");
	}
}
