import java.util.ArrayList;
import java.util.Collections;

public class CardPool
{
	ArrayList< UnoCard > deck = new ArrayList< UnoCard >();
	ArrayList< UnoCard > discard = new ArrayList< UnoCard >();
	ArrayList< UnoCard > hand = new ArrayList< UnoCard >();
	
	final private int standardFaces = 13;
	final private int standardColors = 4;
	
	private int size = 108;
	
	public void generateDeck()
	{	
		int colorCounter = 1;
		int faceCounter = 1;
	
		for ( UnoCard.Color color : UnoCard.Color.values() )
		{
			if( colorCounter == standardColors )
				break;
			else 
			{
				deck.add( new UnoCard(color, UnoCard.Face.ZERO) );
				
				for( UnoCard.Face face : UnoCard.Face.values() ) 
				{
					if( faceCounter == standardFaces )
						break;
					else
						deck.add( new UnoCard(color, face) );
				}
			}
		}
		
		for( int i = 0; i < 4; i++ )
			deck.add( new UnoCard(UnoCard.Color.WILD, UnoCard.Face.BLANK) );
			
		for( int i = 0; i < 4; i++ )
			deck.add( new UnoCard(UnoCard.Color.WILD, UnoCard.Face.DRAW4) );
		
		shuffleDeck();
		
	}

	public void shuffleDeck()
	{
		int random = 0;
		
		for(int i = 0; i < size; i++)
		{
			random = (int)(Math.random() * size);
			
			Collections.swap(deck, i, random);
		}
	}
	
	public void generateHand() //Will generate a hand of size 7, from the "first" card in deck
	{
            for(int i = 0; i < 6; i++){
                hand.add(deck.get(i));
            }
	}
	
	public void draw() //Gets the "top" card in deck and adds to the hand
	{
            hand.add(deck.get(0)); 
	}
}