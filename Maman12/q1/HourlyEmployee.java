
public class HourlyEmployee extends Employee
{
	private double wage; // wage per hour
	private double hours; // hours worked for week
	
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours, int year, int month, int date)
	{
		super(firstName, lastName, socialSecurityNumber, year, month, date);
		
		if(wage < 0.0) // validate wage
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		
		if((hours < 0.0) || (hours > 168.0))// validate hours
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		
		this.wage = wage;
		this.hours = hours;
	}
	
	//set wage
	public void setWage(double wage)
	{
		if(wage < 0.0) // validate wage
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		
		this.wage = wage;
	}
	
	//return wage
	public double getWage()
	{
		return wage;
	}
	
	// set hours worked
	public void setHours(double hours)
	{
		if((hours < 0.0) || (hours > 168.0))// validate hours
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		
		this.hours = hours;
	}
	
	// return hours worked
	public double getHours()
	{
		return hours;
	}
	
	@Override
	public double earnings(boolean isBirthMonth)
	{
		if(getHours() <= 40) // no overtime
			if(isBirthMonth == true)
				return getWage() * getHours() + 200;
			else
				return getWage() * getHours();
		else
			if(isBirthMonth == true)
				return (40 * getWage() + (getHours() - 40) * getWage() * 1.5) + 200;
			else
				return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
	}
	
	@Override
	public String toString()
	{
		return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(), "hours worked", getHours());
	}
}
