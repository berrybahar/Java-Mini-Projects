
public class CommissionEmployee extends Employee
{
	private double grossSales;// gross weekly sales
	private double commissionRate; // comission percentage
	
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, int year, int month, int date)
	{
		super(firstName, lastName, socialSecurityNumber, year, month, date);
		
		if(commissionRate <= 0.0 || commissionRate >= 1.0) //validate
			throw new IllegalArgumentException("Comission rate must be > 0.0 and < 1.0");
		
		if(grossSales < 0.0) // validate
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}
	
	public void setGrossSales(double grossSales)
	{
		if(grossSales < 0.0) // validate
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		
		this.grossSales = grossSales;
	}
	
	public double getGrossSales()
	{
		return grossSales;
	}
	
	public void setCommissionRate(double commissionRate)
	{
		if(commissionRate <= 0.0 || commissionRate >= 1.0) //validate
			throw new IllegalArgumentException("Comission rate must be > 0.0 and < 1.0");
		
		this.commissionRate = commissionRate;
	}
	
	public double getCommissionRate()
	{
		return commissionRate;
	}
	
	@Override
	public double earnings(boolean isBirthMonth)
	{
		if(isBirthMonth == true)
			return (getCommissionRate() * getGrossSales()) + 200;
		return getCommissionRate() * getGrossSales();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", "commission employee", super.toString(), "gross sales", getGrossSales(), "comission rate", getCommissionRate());
	}
}
