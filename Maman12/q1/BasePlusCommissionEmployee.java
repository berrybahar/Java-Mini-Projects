
public class BasePlusCommissionEmployee extends CommissionEmployee
{
	private double baseSalary; // base salary per week
	
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary, int year, int month, int date)
	{
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate, year, month, date);
		
		if(baseSalary < 0.0) //validate baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		
		this.baseSalary = baseSalary;
	}
	
	public void setBaseSalary(double baseSalary)
	{
		if(baseSalary < 0.0) //validate baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		
		this.baseSalary = baseSalary;
	}
	
	public double getBaseSalary()
	{
		return baseSalary;
	}
	
	@Override
	public double earnings(boolean isBirthMonth)
	{
		if(isBirthMonth == true)
			return getBaseSalary() + super.earnings(isBirthMonth);
		return getBaseSalary() + super.earnings(isBirthMonth);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s; %s: $%, .2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
	}
}
