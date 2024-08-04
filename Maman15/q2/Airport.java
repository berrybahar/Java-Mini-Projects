import java.util.HashMap;
import java.lang.Boolean;

public class Airport
{
	private String airportName;
	private int numOfRunways;
	private HashMap<Integer, Boolean> runwayFree;
	
	public Airport(String airportName, int numOfRunways)
	{
		this.airportName = airportName;
		
		if(numOfRunways <= 0)
			this.numOfRunways = 0;
		else
			this.numOfRunways = numOfRunways;
		
		
		runwayFree = new HashMap<Integer, Boolean>();
		for(int i = 1; i <= numOfRunways; i++)
		{
			runwayFree.put(i, true);
		}
	}
	
	public synchronized int depart(String flightNumber)
	{
		int freeRunway = 0;
		
		while((freeRunway = this.returnFreeRunway()) == 0)
		{
			try {
				wait();
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
		
		runwayFree.replace(freeRunway, false);
		notifyAll();
		
		return freeRunway;
	}
	
	public synchronized int land(String flightNumber)
	{
		int freeRunway = 0;
		
		while((freeRunway = this.returnFreeRunway()) == 0)
		{
			try {
				wait();
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
		
		runwayFree.replace(freeRunway, false);
		notifyAll();
		
		return freeRunway;
	}
	
	public synchronized void freeRunway(String flightNumber, int freeRunway)
	{
		runwayFree.replace(freeRunway, true);
	}
	
	public synchronized String getAirportName()
	{
		return airportName;
	}
	
	private synchronized int returnFreeRunway()
	{
		for(int i = 1; i <= numOfRunways; i++)
			if(runwayFree.get(i) == true)
			{
				return i;
			}
		return 0;
	}
}
