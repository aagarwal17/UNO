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
}
