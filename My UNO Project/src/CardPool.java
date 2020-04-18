import java.util.ArrayList;
import java.util.Collections;
public class CardPool
{
	ArrayList< UnoCard > deck = new ArrayList< UnoCard >();
	ArrayList< UnoCard > discard = new ArrayList< UnoCard >();
	ArrayList< UnoCard > hand = new ArrayList< UnoCard >();
	
	final private int standardFaces = 13;
	final private int standardColors = 4;
	
	/* generateDeck() goes through every color and face combination,
	 * adding each card to the deck going along with the uno parameters
	 * of having 108 cards: 1 of each color 0, 2 of each color everything
	 * else, and then four of each wild card
	 */
	public void generateDeck()
	{	
		//counters tracking each iteration of each loop so they can be broken from
		int colorCounter = 0;
		int faceCounter = 0;
	
		//iterate through every color
		for ( UnoCard.Color color : UnoCard.Color.values() )
		{
			//reset the face counter on each iteration
			faceCounter = 0;
			
			//once WILD is reached, stop
			if( colorCounter == standardColors )
				break;
			else 
			{
				//iterate through every face value
				for( UnoCard.Face face : UnoCard.Face.values() ) 
				{
					//only add one zero
					if( faceCounter == 0 )
						deck.add( new UnoCard(color, face) );
					//once BLANK is reached, stop
					else if( faceCounter == standardFaces )
						break;
					//add two of every other face value
					else {
						deck.add( new UnoCard(color, face) );
						deck.add( new UnoCard(color, face) );
					}
					//update face counter
					faceCounter++;
				}
			}
			// update color counter
			colorCounter++;

		}
		
		//now add the wild cards independently of the other cards
		
		for( int i = 0; i < 4; i++ )
			deck.add( new UnoCard(UnoCard.Color.WILD, UnoCard.Face.BLANK) );
			
		for( int i = 0; i < 4; i++ )
			deck.add( new UnoCard(UnoCard.Color.WILD, UnoCard.Face.DRAW4) );
		
		shuffleDeck();
		
	}
	
	public void printDeck()
	{
		//tracks the number of cards in the deck
		int cardNumber = 1;
		
		//iterate through every card in the deck
		for( UnoCard card : deck ) 
		{
			//print a number followed by a card 
			System.out.print( cardNumber + ". ");
			card.printCard(); //method in UnoCard class
			cardNumber++;
		}
	}

	public void shuffleDeck()
	{
		int random = 0;
		
		//iterate through the whole deck
		for(int i = 0; i < deck.size(); i++)
		{
			//the random function returns a double between 0 and 1, so 
			//this scales it to the size of the deck then rounds to an integer
			random = (int)(Math.random() * deck.size());
			
			//swap card in position i with a random card's position in the deck
			Collections.swap(deck, i, random);
		}
	}
	
	//Will generate a hand of size 7, from the "first" card in deck
	//I (John) changed this to take an ArrayList in as a parameter to have it
	//work with any individual player
	public void generateHand(ArrayList<UnoCard> playerHand) 
	{                         
		
		//clear any existing hand (added to streamline)
		playerHand.clear();
		
            for(int i = 0; i < 7; i++){
                playerHand.add(deck.get(0));
                deck.remove(0);  
                //the reason I (John) changed it to adding/removing the 0'th element is because
                //it makes sense to treat any card piles as stacks as we only interact with the top element
                // *this doesn't apply to to hands however*
            }
	}
	
	//prints all the cards in the hand
	public void printHand()
	{
		//tracks the number of cards through iterations
		int cardNumber = 1;
		
		//iterate through all the cards in the hand
		for( UnoCard card : hand )
		{
			//print each card and update the tracker
			System.out.print( cardNumber + ") ");
			card.printCard();
			cardNumber++;
		}
	}
	
	//Adds the top card of the deck to an ArrayList past in
	public void draw( ArrayList<UnoCard> playerHand) 
	{                  
		
		//if the deck is empty, shuffle the discard pile into the deck barring the top card of discard
		if( deck.size() == 0 )
		{
			System.out.println("Deck is empty. Shuffling discard pile");
			shuffleDiscard();
		}
		
        playerHand.add(deck.get(0)); 
        deck.remove(0);
	}
	
	//plays the card based on the number input by the user (temporary, later on button press)
	public void playCard( int handIndex, ArrayList<UnoCard> playerHand )
	{
		//initialize the desired card from the hand
		UnoCard card = playerHand.get( handIndex );
		
		//if the card is playable, put it on the top of the discard pile and remove it from the hand
		if( cardIsPlayable( card ) )
		{
                    if(card.isWild()){
                        //add code to set wild temporary color >> card.setTemp()
                    }
			discard.add( 0, card );
			playerHand.remove( handIndex );
		}
		//otherwise, indicate that the card is unplayable (temporary, will change when integrating UI)
		else
			System.out.println("That card is unplayable");
        }
/*	
	public boolean cardIsPlayable( UnoCard card )
	{
            if(discard.get(0).getColor() == card.getColor()) //Checks if colors match on new card and most recent card played 
            {
                return true;
            }else if(discard.get(0).getFace() == card.getFace()) //Checks face values 
            {
                return true;
            }else if(discard.get(0).isWild() && (discard.get(0).getTemp()== card.getColor()))
                //Checks if wild card and if temporary color matches card color
            {    
                return true;
            }else return card.isWild();
    }
*/
	//version of the function for purely testing purposes
	public boolean cardIsPlayable( UnoCard card )
	{
            return true;
    }
        
	//places the top card of the deck in the discard pile at the start of the game
	public void initializeDiscard()
	{
		//initializes the top card of the deck
		UnoCard firstDiscard = deck.get(0);
		
		//add the card to the discard pile and remove it from te deck
		discard.add( firstDiscard );
		deck.remove(0);
	}
	
	//prints the discard pile (this is mainly for debugging purposes)
	public void printDiscard()
	{
		//tracks the number of cards through iterations
		int cardNumber = 1;
				
		//iterate through all the cards in the discard pile
		for( UnoCard card : discard )
		{
			//print each card and update the tracker
			System.out.print( cardNumber + "* ");
			card.printCard();
			cardNumber++;
		}
	}
	
	//gets the top card in the discard pile
	public UnoCard getTop()
	{
		return( discard.get(0) );
	}
	
	//shuffles the discard pile into the deck, with the exception of the card at the top
	//of the discard pile
	public void shuffleDiscard()
	{
		//initialize the top card
		UnoCard topCard = discard.get(0);
		
		//iterate through every card in the discard pile
		for( UnoCard card : discard )
		{
			//add each card to the deck
			deck.add(card);
		}
		
		//remove the top of the discard pile from the deck, shuffle the deck
		//then replace the top card of the discard pile in the discard pile
		deck.remove(0);
		shuffleDeck();
		discard.clear();
		discard.add( topCard );
	}
	
	//driver (use to test methods)
	public static void main(String[] args)
	{
		CardPool test1 = new CardPool();

		System.out.println("Testing methods:");
		test1.generateDeck();
		test1.printDeck();
		System.out.println("\n\n\n\n\n\n");
		test1.shuffleDeck();
		test1.printDeck();
		System.out.println("\n\n\n\n\n\n");
		test1.generateHand(test1.hand);
		test1.printHand();
		System.out.println("\n\n\n\n\n\n");
		test1.initializeDiscard();
		test1.printDiscard();
		System.out.println("\n\n\n\n\n\n");
		test1.printDeck();
		System.out.println("\n\n\n\n\n\n");
		
		//put hand into discard, check if methods work
		int size = test1.hand.size();
		for( int i = 0; i < size; i++ )
		{
			test1.playCard(0, test1.hand);
		}
		test1.printHand();
		System.out.println("\n\n\n\n\n\n");
		test1.getTop().printCard();
		System.out.println("\n\n\n\n\n");
		test1.printDiscard();
		System.out.println("\n\n\n\n\n\n");
	/*	
		//nuke the deck and see if the draw method's contingency works
		test1.deck.clear();
		test1.draw();
		test1.printHand();
		System.out.println("\n\n\n\n\n\n");
		test1.printDiscard();
		System.out.println("\n\n\n\n\n\n");
		test1.printDeck();
	*/	
		//as of 4/14, these all work-John
	}
}