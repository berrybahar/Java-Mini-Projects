
public class PieceWorker extends Employee
{
	private int numOfPiecesProduced;
	private double piecePrice;
	
	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, int numOfPiecesProduced, double piecePrice, int year, int month, int date)
	{
		super(firstName, lastName, socialSecurityNumber, year, month, date);
		
		if(piecePrice < 0.0)
			throw new IllegalArgumentException("price for piece must be >= 0.0");
		
		this.piecePrice = piecePrice;
		
		if(numOfPiecesProduced < 0)
			throw new IllegalArgumentException("number of pieces produced must be >= 0");
		
		this.numOfPiecesProduced = numOfPiecesProduced;
	}
	
	public void setPiecePrice(double piecePrice)
	{
		if(piecePrice < 0.0)
			throw new IllegalArgumentException("price for piece must be >= 0.0");
		
		this.piecePrice = piecePrice;
	}
	
	public double getPiecePrice()
	{
		return piecePrice;
	}
	
	public void setNumOfPiecesProduced(int numOfPiecesProduced)
	{
		if(numOfPiecesProduced < 0)
			throw new IllegalArgumentException("number of pieces produced must be >= 0");
		
		this.numOfPiecesProduced = numOfPiecesProduced;
	}
	
	public int getNumOfPiecesProduced()
	{
		return numOfPiecesProduced;
	}
	
	@Override
	public double earnings(boolean isBirthMonth)
	{
		if(isBirthMonth == true)
			return (piecePrice * numOfPiecesProduced) + 200;
		return piecePrice * numOfPiecesProduced;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s: %s%n%s: %d; %s: $%,.2f", "piece worker", super.toString(), "number of pieces produced", getNumOfPiecesProduced(), "price for piece", getPiecePrice());
	}
}
