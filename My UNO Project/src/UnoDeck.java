
import java.util.Random;

import javax.swing.ImageIcon;

//Arun Agarwal Deck Class
//this is another version of the Carpool class I think, I made this because it makes more sense to me.
public class UnoDeck 
{
	private UnoCard[] cards;
	private int cardsInDeck;
	
	public UnoDeck()
	{
		cards = new UnoCard[108];
	}
	
	public void reset()
	{
		UnoCard.Color[] colors = UnoCard.Color.values();
		cardsInDeck = 0;
		
		for (int i = 0; i < colors.length - 1; i++)
		{
			UnoCard.Color color = colors[i];
			
			//special case for 0 because there is only one of this card for each color
			cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(0));
			
			//the rest of the cases for the number cards
			for(int j = 1; j < 10; j++)
			{
				cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(j));
				cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(j));
			}
			
			//other special cards
			UnoCard.Value[] values = new UnoCard.Value[] {UnoCard.Value.DrawTwo, UnoCard.Value.Skip, UnoCard.Value.Reverse};
			for (UnoCard.Value value : values)
			{
				for(int i = 0; i < 4; i++)
				{
					cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(0));
				}
			}
			
		}
	}
	
	//replaces the deck with an arraylist of UnoCards (the stockpile)
	public void replaceDeckWith(ArrayList<UnoCard> cards)
	{
		this.cards = cards.toArray(new UnoCard[cards.size()]);
		this.cardsInDeck = this.cards.length;
	}
	
	//
	public boolean isEmpty()
	{
		return cardsInDeck == 0;
	}
	
	public void shuffle()
	{
		int m = cards.length;
		Random random = new Random();
		
		//get a random index of the array past the current index
		//the argument is an exclusive bound
		//swap the random elemeent with the present element
		for (int i = 0; i < cards.length; i++)
		{
			int randomValue = i + random.nextInt(m - 1);
			Uno randomCard = cards[randomValue];
			cards[randomValue] = cards[i];
			cards[i] = randomCard;
		}
	}
	
	public UnoCard drawCard() throws IllegalArgumentException
	{
		if (isEmpty())
		{
			throw new IllegalArgumentException("Cannot draw a card sicne there are no cards in the deck.");
		}
		return cards[cardsInDeck];
	}
	
	public ImageIcon drawCardImage() throws IllegalArgumentException
	{
		if(isEmpty())
		{
			throw new IllegalArgumentException("Cannot draw a card since the deck is empty.");
		}
		return new ImageIcon(cards[cardsInDeck].toString() + ".png");
	}
	
	public UnoCard[] drawCard (int m)
	{
		if (m < 0)
		{
			throw new IllegalArgumentException("must draw positive cards but tried to draw " + m + " cards.");
		}
		
		if (m > cardsInDeck)
		{
			throw new IllegalArgumentException("Cannot draw " + m + " cards since there are only " + cardsInDeck + " cards.");
		}
		
		UnoCard[] ret = new UnoCard[m];
		
		for (int i = 0; i < m; i++)
		{
			ret[i] = cards[cardsInDeck];
		}
		
		return ret;
	}
}
