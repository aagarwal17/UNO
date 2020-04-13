//UNO Final Project Player Class 
import java.util.ArrayList;
public class Player 
{
    public String name;
    public ArrayList<UnoCard> hand = new ArrayList< UnoCard >();
    public Player(String player_name, ArrayList player_hand){
        this.name = player_name;
        this.hand = player_hand;
    }
}
