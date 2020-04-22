package src;
 import java.util.ArrayList;
public class Player 
{
    public String name;
    public ArrayList<UnoCard> hand = new ArrayList< UnoCard >();
    
    public Player(String player_name, ArrayList<UnoCard> player_hand){
        this.name = player_name;
        this.hand = player_hand;
    }
    
    //John - added a second constructor to make testing easier in TextGame
    public Player(int player_number, ArrayList<UnoCard> player_hand){
        this.name = "Player " + player_number;
        this.hand = player_hand;
    }
    
    //took out parameter to work with testing in TextGame
    public int getHandSize(){
        return hand.size();
    }
    
    public UnoCard getCardAt(int index){
        return hand.get(index);
    }
    
    //for debugging/text-based purposes
    public void printHand()
    {
    	int i = 1;
    	
    	for( UnoCard cards : hand)
    	{
    		System.out.print(i + ") ");
    		cards.printCard();
    		i++;
    	}
    }
    
    
    public String getPlayerName(Player p){
        return p.name;
    }
    
    //for debugging/text-based purposes
    public void printNameAndHand()
    {
    	System.out.println(name + " here is your hand:");
    	printHand();
    }
    
    public void setPlayerName(Player p, String newName){
        p.name = newName;
    }
    
    public ArrayList<UnoCard> getHand(Player p){
        return p.hand;
    }
    
    //driver to test functions
    public static void main(String[] args)
    {
    	CardPool testHand = new CardPool();
    	testHand.generateDeck();
    	
    	Player testPlayer1 = new Player("John", testHand.deck);
    	Player testPlayer2 = new Player(27, testHand.deck);
    	
    	testPlayer1.printHand();
    	System.out.println("\n\n");
    	testPlayer1.printNameAndHand();
    	System.out.println("\n\n");
    	testPlayer2.printNameAndHand();
    	
    }
}
