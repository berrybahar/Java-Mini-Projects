
public class BirthDate
{
	private int year;
	private int month;
	private int date;
	
	public BirthDate(int year, int month, int date)
	{
		if(year < 0)
			throw new IllegalArgumentException("Year should be a positive number!");
		
		if(month > 12 || month < 1)
			throw new IllegalArgumentException("There are 12 months in a year!");
		
		if(daysInMonth(month) < date || date < 0)
			throw new IllegalArgumentException("The date you entered is illegal!");
			
		this.year = year;
		this.month = month;
		this.date = date;
	}
	
	public void setDate(int date)
	{
		if(daysInMonth(month) < date || date < 0)
			throw new IllegalArgumentException("The date you entered is illegal!");
		
		this.date = date;
	}
	
	public int getDate()
	{
		return date;
	}
	
	public void setMonth(int month)
	{
		if(month > 12 || month < 1)
			throw new IllegalArgumentException("There are 12 months in a year!");
		
		this.month = month;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public void setYear(int year)
	{
		if(year < 0)
			throw new IllegalArgumentException("Year should be a positive number!");
		
		this.year = year;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String toString()
	{
		return this.date + "/" + this.month + "/" + this.year;
	}
	
	public int daysInMonth(int month)
	{
		int daysInMonth = 0;
		switch(month)
		{
			case 1:
				daysInMonth = 31;
				break;
			case 2:
				daysInMonth = 28;
				break;
			case 3:
				daysInMonth = 31;
				break;
			case 4:
				daysInMonth = 30;
				break;
			case 5:
				daysInMonth = 31;
				break;
			case 6:
				daysInMonth = 30;
				break;
			case 7:
				daysInMonth = 31;
				break;
			case 8:
				daysInMonth = 31;
				break;
			case 9:
				daysInMonth = 30;
				break;
			case 10:
				daysInMonth = 31;
				break;
			case 11:
				daysInMonth = 30;
				break;
			case 12:
				daysInMonth = 31;
				break;
		}
		return daysInMonth;
	}
}
