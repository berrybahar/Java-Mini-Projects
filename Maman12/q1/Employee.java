// Employee abstract superclass

public abstract class Employee 
{
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private final BirthDate birthDate;
	
	// constructor
	public Employee(String firstName, String lastName, String socialSecurityNumber, int year, int month, int date)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthDate = new BirthDate(year, month, date);
	}
	
	// return first name
	public String getFirstName()
	{
		return firstName;
	}
	
	// return last name
	public String getLastName()
	{
		return lastName;
	}
	
	// return social security number
	public String getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}
	
	public BirthDate getBirthDate()
	{
		return birthDate;
	}
	
	// return String representation of Employee object
	@Override
	public String toString()
	{
		return String.format("%s %s%nsocial security number: %s%nbirth date: %s", getFirstName(), getLastName(), getSocialSecurityNumber(), getBirthDate().toString());
	}
	
	// abstract method must be overridden by concrete subclasses
	public abstract double earnings(boolean isBirthMonth);
}
