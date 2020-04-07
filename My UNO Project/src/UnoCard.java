import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;
//UNO Card Class for Final Project

// John 4/27, added getters/setters and deck methods
// for some reason am unable to see eclipse errors, so 
// I can't actually tell if what I wrote works or not
// Also want to add CardPool class but again am unable to
// and also unable to make pull requests still, so
// organization may be undesirable
public class UnoCard 
{
	public enum Color { RED, YELLOW, BLUE, GREEN, WILD }
	public enum Face  { ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, 
					    EIGHT, NINE, SKIP, REVERSE, DRAW2, BLANK, DRAW4 }

	Color hue;
	Face command;
	
	public UnoCard( Color newColor, Face newFace )
	{
		this.hue = newColor;
		this.command = newFace;
	}
	
	public void setColor(Color newColor)
	{
		this.hue = newColor;
	}
	
	public Color getColor()
	{
		return hue;
	}
	
	public void setCommand(Face newFace)
	{
		this.command = newFace;
	}
	
	public Face getFace()
	{
		return command;
	}
}

public class CardPool
{
	ArrayList< UnoCard > deck = new ArrayList< UnoCard >;
	ArrayList< UnoCard > discard = new ArrayList< UnoCard >;
	ArrayList< UnoCard > hand = new ArrayList< UnoCard >;
	
	private int size = 108;
	
	public void generateDeck()
	{	
		private int standardColors = 4;
		private int colorCounter = 1;
		
		private int standardFaces = 13;
		private int faceCounter = 1;
		
		for( UnoCard.Color color : UnoCard.Color.values() )
		{
			if( colorCounter == standardColors )
				break;
			else {
				deck.add( UnoCard(color, UnoCard.Face.ZERO) )
				
				for( UnoCard.Face face : UnoCard.Face.values() ) {
					if( faceCounter == standardFaces )
						break;
					else
						deck.add( UnoCard(color, face) );
				}
			}
		}
		
		for( int i = 0; i < 4; i++ )
			deck.add( UnoCard(UnoCard.Color.WILD, UnoCard.Face.BLANK) );
			
		for( int i = 0; i < 4; i++ )
			deck.add( UnoCard(UnoCard.Color.WILD, UnoCard.Face.DRAW4) );
		
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
	
	public void generateHand()
	{
		
	}
	
	public void draw()
	{
		
	}
	
	
}
