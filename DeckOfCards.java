// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom;
import java.util.ArrayList;

public class DeckOfCards 
{
	private ArrayList<Card> deck; // array of Card objects
	private int currentCard; // index of next Card to be dealt (0-51)
	private static final int NUMBER_OF_CARDS = 52;
	// random number generator
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final String [] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
	private static final String [] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	 
	// constructor fills deck of Cards
	public DeckOfCards()
	{	
		deck = new ArrayList<Card>(); // create array Card objects
		currentCard = 0; // first Card dealt will be deck[0]
		
		// populate deck with Card objects
		for(int count = 0; count < NUMBER_OF_CARDS; count++)
			deck.add(new Card(faces[count % 13], suits[count / 13]));
	}
	
	// constructor for player cards 
	public DeckOfCards(String player)
	{
		deck = new ArrayList<Card>();
	}
	
	// shuffle deck of Cards with one-pass algorithm
	public void shuffle() 
	{
		// next call to method dealCard should start at deck[0] again
		currentCard = 0 ;
		
		//for each Card, pick another random Card (0-51) and swap them
		for(int first = 0; first < this.deck.size(); first++)
		{
			//select a random number between 0 and 51
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			
			//swap current Card with randomly selected Card
			Card temp = this.deck.get(second);
			this.deck.set(first, this.deck.get(second));
			this.deck.set(second, temp);
		}
	}
	//for getting the list of cards
	public ArrayList<Card> getDeck()
	{
		return this.deck;
	}
	
	//deal one Card
	public Card dealCard()
	{
		//determine whether Cards remain to be dealt
		if(currentCard < deck.size())
			return deck.get(currentCard++); // return current Card in array
		else
			return null;//return null to indicate that all Cards were dealt
	}
	//when a player wins he gets the card of the losing player
	//and puts at the bottom of the deck
	public void playerWon(DeckOfCards loser)
	{
		this.putTheCardAtBottom();
		
		this.getDeck().add(new Card("Ace", "Hearts"));//add a card just for swapping
		
		this.putTheCardAtBottom();
		
		this.getDeck().set(0, new Card(loser.getDeck().get(loser.getDeck().size()-1).getFace(), loser.getDeck().get(loser.getDeck().size()-1).getSuit()));
		loser.getDeck().remove(loser.getDeck().size()-1);
	}
	//puts the card at the top to the bottom of the deck
	public void putTheCardAtBottom()
	{
		Card temp;
		for(int i = this.getDeck().size() - 1; i > 0; i--)
		{
			temp = this.getDeck().get(i);
			this.getDeck().set(i, this.getDeck().get(i - 1));
			this.getDeck().set(i - 1, temp);
		}
	}
}
