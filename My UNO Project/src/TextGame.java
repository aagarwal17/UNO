import java.util.ArrayList;
import java.util.Scanner;

public class TextGame {
		
	ArrayList<Player> players = new ArrayList<Player>();
	CardPool cards = new CardPool();
	Player currentPlayer;
	Player winner;
	UnoCard lastPlayed;
	Scanner keyboard = new Scanner(System.in);
	
	private int playerCount;
	private int playerIndex = 0;
	private int handIndex;
	private boolean reversed;
	
	//self explanatory
	public void startGame()
	{
		cards.generateDeck();
		cards.initializeDiscard();
	}
	
	//sets the amount of players, their names, their decks, and the current player
	//(set as player 1)  low priority: we can add a name prompt here at a later date
	public void initializePlayers()
	{
		getPlayerCount();
		
		//populate the array with players by getting hands from the deck and
		//naming each player by number
		for(int i = 0; i < playerCount; i++)
		{
			ArrayList<UnoCard> temporary = new ArrayList<UnoCard>();
			cards.generateHand(temporary);
			players.add( new Player(i + 1, temporary));
		}
		//initialize the current player as player 1
		currentPlayer = players.get(0);
	}
	
	//gets the amount of players from the user
	//low priority: add protection against integers <= 0
	public void getPlayerCount()
	{
		System.out.print("How many people are playing? ");
		playerCount = keyboard.nextInt();
		System.out.println("\n\n");
	}
	
	//allows the current player to play a card, or draw if they do not have 
	//***NOT EVERYTHING HERE IS TESTED. Currently, it only works if every card is playable***
	public void playerTurn()
	{
		currentPlayer.printHand();
		
		//if no card is playable, draw a card
		if(noCardsPlayable()) {
			System.out.println("\n\nNone of " + currentPlayer.name + "'s cards are playable. He/she now draws a card.");
			cards.draw(currentPlayer.hand);
			
			int drawnIndex = currentPlayer.getHandSize() - 1;
			UnoCard drawn = currentPlayer.hand.get( drawnIndex );
			
			//if the drawn card is playable, play it and update the last card played
			if(cards.cardIsPlayable(drawn)) {
				cards.playCard(drawnIndex, currentPlayer.hand);
				lastPlayed = drawn;
				System.out.println("The card you drew is playable, so you play it");
			}
		}
		
		else {
			System.out.print("\n\nWhich card will you play " + currentPlayer.name + "? >");
			handIndex = keyboard.nextInt() - 1;
			boolean cardPlayed = false;
			int handSize = currentPlayer.getHandSize();
			
			while(!cardPlayed) {
				cards.playCard(handIndex, currentPlayer.hand);
				if(currentPlayer.getHandSize() < handSize)
					cardPlayed = true;
			}
			
			lastPlayed = cards.discard.get(0);
		}
	}

	//finds the next player in the turn order
	public void nextPlayer()
	{
		checkIfReversePlayed();
		
		//if the turn order is standard
		if(!reversed) {
			//if skip is played, iterate through the available players twice in increasing order
			if(skipPlayed()) {
				playerIndex++;
				checkPlayerIndex();
				playerIndex++;
				checkPlayerIndex();
			}
			//otherwise, only do so once
			else {
				playerIndex++;
				checkPlayerIndex();
			}
		}
		//if the turn order is reversed
		else {
			//if skip is played, iterate through the available players twice in decreasing order
			if(skipPlayed()) {
				playerIndex--;
				checkPlayerIndex();
				playerIndex--;
				checkPlayerIndex();
			}
			//otherwise, only do so once
			else {
				playerIndex--;
				checkPlayerIndex();
			}
		}
		
		currentPlayer = players.get(playerIndex);
	}
	
	//checks if the player number is out of bounds, if it is, resets it based on
	//whether the order is reversed or not
	public void checkPlayerIndex() 
	{
		if(playerIndex == playerCount)
			playerIndex = 0;
		else if(playerIndex == -1)
			playerIndex = playerCount - 1;
	}
	
	//returns true if the last card played is a skip
	public boolean skipPlayed()
	{
		boolean flag = false;
		
		if(lastPlayed.getFace() == UnoCard.Face.SKIP)
			flag = true;
		
		return flag;
	}
	
	//returns true if the last card played is a skip
	public void checkIfReversePlayed()
	{
		if(lastPlayed.getFace() == UnoCard.Face.REVERSE)
			this.reversed = !this.reversed;
	}
	
	//stub
	public boolean drawPlayed()
	{
		return false;
	}
	
	//stub
	public boolean wildPlayed()
	{
		return false;
	}
	
	//stub
	public boolean noCardsPlayable()
	{
		return false;
	}
	
	//returns true if a player has run out of cards
	public boolean gameOver()
	{
		boolean flag = false;
		
		//iterate through every player
		for(Player participant : players) {
			//if the hand is empty, return true and save the winning player
			if(participant.getHandSize() == 0) {
				flag = true;
				winner = participant;
				break;
			}
		}
		return flag;
	}
	
	//has players say "UNO! once they reach one card
	public void uno()
	{
		if(currentPlayer.getHandSize() == 1)
			System.out.println("\n" + currentPlayer.name + " said \"UNO!\"\n");
	}
	
	//the main function for the text-based version
	//any code commented out is for testing functions, so leave them in just in case
	//John - 4/18: all present functions work
	public static void main(String[] args)
	{
		TextGame game = new TextGame();
		
		game.startGame();
		
	//	game.cards.printDeck();
	//	game.cards.printDiscard();
		
		game.initializePlayers();
		
		while(!game.gameOver()) {
			
			game.playerTurn();
			game.uno();
			game.nextPlayer();
		}
		
		System.out.println("\n\n*** Congratulations " + game.winner.name + "! You won! ***");
	/*	for( Player participant : game.players)
		{
			participant.printNameAndHand();
			System.out.println("\n\n");
		}
		game.cards.printDeck();
		
		while(game.players.get(0).getHandSize() > 0)
		{
			game.cards.playCard(0, game.players.get(0).hand);
		}
	
	  
		game.cards.draw(game.players.get(0).hand);
		
		game.cards.printDiscard();
		game.cards.printDeck();
		game.players.get(0).printHand();
	*/	
	}
}
