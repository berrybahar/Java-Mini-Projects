import java.util.ArrayList;
import java.util.Random;

public class Main 
{
	public static void main(String[] args) 
	{
		Random random = new Random();
		int departure = 0;
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		
		Airport Istanbul = new Airport("Istanbul", 3);
		Airport TelAviv = new Airport("Tel-Aviv", 3);
		
		for(int i = 1; i <= 10; i++)
		{
			departure = random.nextInt(1, 3);
			if(departure == 1)
				flightList.add(new Flight("TK" + i, Istanbul, TelAviv));
			else
				flightList.add(new Flight("TK" + i, TelAviv, Istanbul));
		}
		
		for(int i = 0; i < flightList.size(); i++)
		{
			flightList.get(i).start();
			try {
				Thread.sleep(random.nextInt(3000, 5001));
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}
