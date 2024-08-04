
public class Person implements Comparable<Person>
{
	private String name;
	private String idNumber;
	private int birthYear;
	
	public Person(String name, String idNumber, int birthYear)
	{
		this.name = name;
		this.idNumber = idNumber;
		this.birthYear = birthYear;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getIdNumber()
	{
		return idNumber;
	}
	
	public int getBirthYear()
	{
		return birthYear;
	}
	
	@Override
	public int compareTo(Person o) 
	{
		if(o.birthYear < this.birthYear)
			return 1;
		else if(o.birthYear > this.birthYear)
			return -1;
		
		return 0;
	}
	
}
