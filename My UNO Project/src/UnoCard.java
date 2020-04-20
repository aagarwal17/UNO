package src;


//UNO Card Class for Final Project

public class UnoCard 
{

    Color setTemp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	public enum Color { RED, YELLOW, BLUE, GREEN, WILD }
	public enum Face  { ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, 
					    EIGHT, NINE, SKIP, REVERSE, DRAW2, BLANK, DRAW4 }

	Color hue;
	Face command;
	Color tempColor; //Temporary chosen color for wild
        
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
	
        public Color getTemp() //Gets temporary wild color
        {
            return tempColor;
        }
        
        public void setTemp(Color newColor) //Sets temporary wild color when a wild card is played
        {
            this.tempColor = newColor;
        }
        
        
	public void setFace(Face newFace)
	{
		this.command = newFace;
	}
	
	public Face getFace()
	{
		return command;
	}
	
        public boolean isWild() //Checks if the card is a wild card
        {
            return this.hue == Color.WILD;
        }
        
    public void printCard()
	{
		if( this.command == Face.BLANK )
			System.out.println( hue + "");
		else
			System.out.println( hue + " " + command);
	}
	
	//driver (use to test methods)
	public static void main(String[] args)
	{
		UnoCard test1 = new UnoCard(Color.RED, Face.ZERO);
		UnoCard test2 = new UnoCard(Color.WILD, Face.BLANK);
		
		test1.printCard();
		test2.printCard();
	}
}
/**
public class UnoCard
{
	enum Color
	{
		Red, Blue, Green, Yellow, Wild;
		
		private static final Color [] colors = Color.values();
		public static Color getColor(int i)
		{
			return Color.colors[i];
		}
		
	}
	
	enum Value
	{
		Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, DrawTwo, Skip, Reverse, Wild, Wild_Four;
		
		private static final Value [] values = Value.values();
		public static Value getValue(int i)
		{
			return Value.values[i];
		}
		
	}
	
	private final Color color;
	private final Value value;
	
	public UnoCard(final Color color, final Value value)
	{
		this.color = color;
		this.value = value;
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	public Value getValue()
	{
		return this.value;
	}
	
	public String toString()
	{
		return color + "_" + value;
	}
}
**/