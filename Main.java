import java.util.ArrayList;
import javax.swing.JOptionPane;

//maman 11, Berk Beri Bahar, 345445126
//Executes the card game "War"
public class Main {

	public static void main(String[] args) 
	{
		final int NUMBER_OF_CARDS = 52;
		DeckOfCards deckOfGame = new DeckOfCards();
		deckOfGame.shuffle();//shuffles the deck
		DeckOfCards deckPlayerOne = new DeckOfCards("P1");
		DeckOfCards deckPlayerTwo = new DeckOfCards("P2");
		for(int i = 0; i < NUMBER_OF_CARDS; i += 2)//sharing the cards between the two players
		{
			deckPlayerOne.getDeck().add(new Card(deckOfGame.getDeck().get(i).getFace(), deckOfGame.getDeck().get(i).getSuit()));
			deckPlayerTwo.getDeck().add(new Card(deckOfGame.getDeck().get(i + 1).getFace(), deckOfGame.getDeck().get(i + 1).getSuit()));
		}
		
		boolean noWinner = true;
		boolean inWar = false;
		ArrayList<Card> warPlayerOne = new ArrayList<Card>();
		ArrayList<Card> warPlayerTwo = new ArrayList<Card>();
		int warPlayerSize;//size of the cards for the war list
		int round = 0;
		
		JOptionPane.showMessageDialog(null, "Welcome to the War Card Game\n Please press OK to start the game.");
		
		while(noWinner)
		{
			round++;
			if(deckPlayerOne.getDeck().get(deckPlayerOne.getDeck().size()-1).getCardFaceNumber() > deckPlayerTwo.getDeck().get(deckPlayerTwo.getDeck().size()-1).getCardFaceNumber())
			{//if the card of the P1 is bigger
				printWinner(deckPlayerOne.getDeck(), deckPlayerTwo.getDeck(), "P1", round, inWar);
				deckPlayerOne.playerWon(deckPlayerTwo);
			}else if(deckPlayerOne.getDeck().get(deckPlayerOne.getDeck().size()-1).getCardFaceNumber() < deckPlayerTwo.getDeck().get(deckPlayerTwo.getDeck().size()-1).getCardFaceNumber())
			{//if the card of the P2 is bigger
				printWinner(deckPlayerOne.getDeck(), deckPlayerTwo.getDeck(), "P2", round, inWar);
				deckPlayerTwo.playerWon(deckPlayerOne);
			}else if(deckPlayerOne.getDeck().get(deckPlayerOne.getDeck().size()-1).getCardFaceNumber() == deckPlayerTwo.getDeck().get(deckPlayerTwo.getDeck().size()-1).getCardFaceNumber())
			{//if both of the numbers of cards are the same
				inWar = true;
				
				printWinner(deckPlayerOne.getDeck(), deckPlayerTwo.getDeck(), "start war", round, inWar);
				
				//sends the cards to the lists of the war cards
				warPlayerOne.add(deckPlayerOne.getDeck().get(deckPlayerOne.getDeck().size() - 1));
				deckPlayerOne.getDeck().remove(deckPlayerOne.getDeck().size() - 1);
				
				warPlayerTwo.add(deckPlayerTwo.getDeck().get(deckPlayerTwo.getDeck().size() - 1));
				deckPlayerTwo.getDeck().remove(deckPlayerTwo.getDeck().size() - 1);
				
				if((deckPlayerOne.getDeck().size() >= 3) && (deckPlayerTwo.getDeck().size() >= 3))
				{//if both of the players has at least 3 cards at the war
					while(inWar && (deckPlayerOne.getDeck().size() >= 3) && (deckPlayerTwo.getDeck().size() >= 3))
					{
						for(int i = 1; i <= 3; i++)
						{//adds three cards for the both of the players for their war lists
							warPlayerOne.add(deckPlayerOne.getDeck().get(deckPlayerOne.getDeck().size() - 1));
							deckPlayerOne.getDeck().remove(deckPlayerOne.getDeck().size() - 1);
							
							warPlayerTwo.add(deckPlayerTwo.getDeck().get(deckPlayerTwo.getDeck().size() - 1));
							deckPlayerTwo.getDeck().remove(deckPlayerTwo.getDeck().size() - 1);
						}
						
						if(warPlayerOne.get(warPlayerOne.size() - 1).getCardFaceNumber() > warPlayerTwo.get(warPlayerTwo.size() - 1).getCardFaceNumber())
						{//if the card of the P1 is bigger
							printWinner(warPlayerOne, warPlayerTwo, "P1", round, inWar);
							warPlayerSize = warPlayerOne.size() + warPlayerTwo.size();//the number of the cards that the winner will get
							while((warPlayerOne.size() >= 1) && (warPlayerTwo.size() >= 1))
							{//P1 gets all of the cards from the war
								deckPlayerOne.getDeck().add(warPlayerOne.get(warPlayerOne.size() - 1));
								warPlayerOne.remove(warPlayerOne.size() - 1);
								deckPlayerOne.getDeck().add(warPlayerTwo.get(warPlayerTwo.size() - 1));
								warPlayerTwo.remove(warPlayerTwo.size() - 1);
							}
							
							for(int i = 1; i <= warPlayerSize; i++)//send the added cards to bottom
								deckPlayerOne.putTheCardAtBottom();
							
							inWar = false;
						}else if(warPlayerOne.get(warPlayerOne.size() - 1).getCardFaceNumber() < warPlayerTwo.get(warPlayerTwo.size() - 1).getCardFaceNumber())
						{//if the card of the P2 is bigger
							printWinner(warPlayerOne, warPlayerTwo, "P2", round, inWar);
							warPlayerSize = warPlayerOne.size() + warPlayerTwo.size();//the number of the cards that the winner will get
							while((warPlayerOne.size() >= 1) && (warPlayerTwo.size() >= 1))
							{//P1 gets all of the cards from the war
								deckPlayerTwo.getDeck().add(warPlayerOne.get(warPlayerOne.size() - 1));
								warPlayerOne.remove(warPlayerOne.size() - 1);
								deckPlayerTwo.getDeck().add(warPlayerTwo.get(warPlayerTwo.size() - 1));
								warPlayerTwo.remove(warPlayerTwo.size() - 1);
							}
							
							for(int i = 1; i <= warPlayerSize; i++)//send the added cards to bottom
								deckPlayerTwo.putTheCardAtBottom();
							
							inWar = false;
						}else if(warPlayerOne.get(warPlayerOne.size() - 1).getCardFaceNumber() == warPlayerTwo.get(warPlayerTwo.size() - 1).getCardFaceNumber())
						{//if both of the numbers of cards are the same
							printWinner(warPlayerOne, warPlayerTwo, "continue war", round, inWar);
						}
					}
				}else
				{//if any of the does not have at least three cards at the war
					if(deckPlayerOne.getDeck().size() < 3)
					{
						JOptionPane.showMessageDialog(null, "P1 has less than three cards.\n\nThe Winner of the Game is P2");
						noWinner = false;
					}else if(deckPlayerTwo.getDeck().size() < 3) {
						JOptionPane.showMessageDialog(null, "P2 has less than three cards.\n\nThe Winner of the Game is P1");
						noWinner = false;
					}
				}
			}
			
			if(deckPlayerOne.getDeck().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "The Winner of the Game is P2");
				noWinner = false;
			}
			else if(deckPlayerTwo.getDeck().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "The Winner of the Game is P1");
				noWinner = false;
			}
		}
	}
	
	public static void printWinner(ArrayList<Card> playerOne, ArrayList<Card> playerTwo, String status, int round, boolean inWar)
	{
		String numbers = "The number of P1's card is: " + playerOne.get(playerOne.size() - 1).getCardFaceNumber() +
				"\n\nThe number of the P2's card is: " + playerTwo.get(playerTwo.size() - 1).getCardFaceNumber();
		String r = "\n\nAnd the winner of the Round " + round;
		String winnerWar = "\n\nAnd the winner of the War";
		String winnerOne = " is P1!";
		String winnerTwo = " is P2!";
		String warTime = "\n\nAnd it's WAR TIME!";
		String warCont = "\n\nAnd the war Ongoes";
		
		if(status.equals("start war"))
			JOptionPane.showMessageDialog(null, numbers + warTime);
		else if(status.equals("continue war"))
			JOptionPane.showMessageDialog(null, numbers + warCont);
		
		if(status.equals("P1"))
		{
			if(inWar == false)
				JOptionPane.showMessageDialog(null, numbers + r + winnerOne);
			else
				JOptionPane.showMessageDialog(null, numbers + r + winnerWar + winnerTwo);
		}else if(status.equals("P2"))
		{
			if(inWar == false)
				JOptionPane.showMessageDialog(null, numbers + r + winnerTwo);
			else
				JOptionPane.showMessageDialog(null, numbers + r + winnerWar + winnerTwo);
		}
	}
}