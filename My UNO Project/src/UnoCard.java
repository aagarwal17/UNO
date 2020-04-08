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