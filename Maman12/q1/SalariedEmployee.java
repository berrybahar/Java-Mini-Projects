
public class SalariedEmployee extends Employee
{
	private double weeklySalary;
	
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary, int year, int month, int date)
	{
		super(firstName, lastName, socialSecurityNumber, year, month, date);
		
		if(weeklySalary < 0.0)
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		
		this.weeklySalary = weeklySalary;
	}
	
	public void setWeeklySalary(double weeklySalary)
	{
		if(weeklySalary < 0.0)
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		
		this.weeklySalary = weeklySalary;
	}
	
	public double getWeeklySalary()
	{
		return weeklySalary;
	}
	
	@Override
	public double earnings(boolean isBirthMonth)
	{
		if(isBirthMonth == true)
			return getWeeklySalary() + 200;
		return getWeeklySalary();
	}
	
	@Override
	public String toString()
	{
		return String.format("salaried employee: %s%n%s: $%, .2f", super.toString(), "weekly salary", getWeeklySalary());
	}
}
