// Card class represents a playing card.

public class Card 
{
	private final String face; // face of card ("Ace", "Deuce", ...)
	private final String suit; // suit of card ("Hearts, "Diamonds", ...)
	
	// two-argument constructor initializes card's face and suit
	public Card(String cardFace, String cardSuit)
	{
		this.face = cardFace; // initialize face of card
		this.suit = cardSuit; // initialize suit of card
	}
	//getting the face of card
	public String getFace()
	{
		return this.face;
	}
	//getting the suit of the card
	public String getSuit()
	{
		return this.suit;
	}
	//getting the face of the number as integer
	public int getCardFaceNumber()
	{
		int numOfCard = 0;
		String faceOfCard = this.face;
		
		switch(faceOfCard)
		{
			case "Ace":
				numOfCard = 1;
				break;
			case "Deuce":
				numOfCard = 2;
				break;
			case "Three":
				numOfCard = 3;
				break;
			case "Four":
				numOfCard = 4;
				break;
			case "Five":
				numOfCard = 5;
				break;
			case "Six":
				numOfCard = 6;
				break;
			case "Seven":
				numOfCard = 7;
				break;
			case "Eight":
				numOfCard = 8;
				break;
			case "Nine":
				numOfCard = 9;
				break;
			case "Ten":
				numOfCard = 10;
				break;
			case "Jack":
				numOfCard = 11;
				break;
			case "Queen":
				numOfCard = 12;
				break;
			case "King":
				numOfCard = 13;
				break;
		}
		
		return numOfCard;
	}
	
	//return String representation of Card
	public String toString()
	{
		return face + " of " + suit;
	}
}
