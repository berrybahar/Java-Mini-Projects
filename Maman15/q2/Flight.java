import java.util.Random;

public class Flight extends Thread
{
	private String flightNumber;
	private Airport departureAirport;
	private Airport arrivalAirport;
	private int freeRunway = 0;
	Random random = new Random();
	
	public Flight(String flightNumber, Airport departureAirport, Airport arrivalAirport)
	{
		this.flightNumber = flightNumber;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}
	
	@Override
	public void run()
	{
		super.run();
		
		freeRunway = departureAirport.depart(flightNumber);
		
		System.out.println("\nRunway: " + freeRunway + " of "+ departureAirport.getAirportName() + " Airport is free for the departure of flight:" + flightNumber);
		System.out.println("\nFlight: " + flightNumber + " from " + departureAirport.getAirportName() + " to " + arrivalAirport.getAirportName() +" is taking off");
		try {
			sleep(random.nextInt(2000, 5001));
		} catch (InterruptedException e) { e.printStackTrace(); }
		System.out.println("\nFlight: " + flightNumber + " departed from " + departureAirport.getAirportName());
		departureAirport.freeRunway(flightNumber, freeRunway);
		System.out.println("\nRunway: " + freeRunway + " of "+ departureAirport.getAirportName() + " is free");
		
		System.out.println("\nFlight: " + flightNumber + " is flying");
		try {
			sleep(random.nextInt(770, 7701));
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		freeRunway = arrivalAirport.land(flightNumber);
		System.out.println("\nRunway: " + freeRunway + " of " + arrivalAirport.getAirportName() +" Airport is free for the arrival of flight:" + flightNumber);
		System.out.println("\nFlight: " + flightNumber + " from " + departureAirport.getAirportName() + " to " + arrivalAirport.getAirportName() +" is landing");
		try {
			sleep(random.nextInt(2000, 5001));
		} catch (InterruptedException e) { e.printStackTrace(); }
		System.out.println("\nFlight: " + flightNumber + " arrived to " + arrivalAirport.getAirportName());
		arrivalAirport.freeRunway(flightNumber, freeRunway);
		System.out.println("\nRunway: " + freeRunway + " of " + arrivalAirport.getAirportName() + " is free");
	}
}
