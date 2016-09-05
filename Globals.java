import java.util.ArrayList;

//  Used for global constants only.  Must have the static and final keywords to be global constants

public class Globals 
{
	public static final int FRAME_HI = 1080;
	public static final int FRAME_WI = 1920;
	public static final int CARD_HI = 350;
	public static final int CARD_WI = 250;
	public static final int BUTTON_HI = 50;
	public static final int BUTTON_WI = 100;
	
	public static final int LEFT_STAND_LOCX = 400;
	public static final int LEFT_STAND_LOCY = 950;
	public static final int LEFT_HIT_LOCX = LEFT_STAND_LOCX + 150;
	public static final int LEFT_HIT_LOCY = LEFT_STAND_LOCY;
	
	public static final int RIGHT_STAND_LOCX = 1000;
	public static final int RIGHT_STAND_LOCY = LEFT_STAND_LOCY;
	public static final int RIGHT_HIT_LOCX = RIGHT_STAND_LOCX + 150;
	public static final int RIGHT_HIT_LOCY = RIGHT_STAND_LOCY;
	public static final int BET_SIZE = 10; 
	
	public static final int CARD_HORIZONTAL_SPACING = 60;
	private static final int CARD_VERTICAL_SPACING = 100;
	private static final int DEALER_CARDS_MAX = 10;
	private static final int PLAYER_HAND_MAX = 5;
	
	//  Setting the locations for the dealer's cards
	public static final int D_ONE_LOCX = (FRAME_WI / 2) - ((CARD_HORIZONTAL_SPACING * DEALER_CARDS_MAX) / 2);
	public static final int D_ONE_LOCY = CARD_VERTICAL_SPACING;
	
	// setting the locations for the player's cards
	public static final int P_ONE_LOCX = (FRAME_WI / 2) - (CARD_HORIZONTAL_SPACING * 20 / 2);
	public static final int P_ONE_LOCY = CARD_VERTICAL_SPACING * 2 + CARD_HI;
	
	public static final int P_SIX_LOCX = P_ONE_LOCX + (CARD_HORIZONTAL_SPACING * 7);
	
	public static void shuffle(ArrayList<Card> deck)
	{
		
		//  ASSIGNMENT:  Shuffle the deck with a random number generator.
		//  Link to info on how the RNG works in Java: http://www.javapractices.com/topic/TopicAction.do?Id=62 
		
		//****  This is just an example of how to do a switch using the equals function I added to the card class
		//  Note that the deck list starts counting at 0, so the last card will be card 51
		Card temp = new Card('0', '0', 0, "");
		
		temp.equals(deck.get(1));
		deck.get(0).equals(deck.get(2));
		deck.get(1).equals(temp);
		//****
	}
	
}
