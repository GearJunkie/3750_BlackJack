import java.util.ArrayList;

import javax.swing.JFrame;

public class MainFrame extends JFrame 
{
	ArrayList<Card> deck = new ArrayList<Card>();
	
	CardPanel[] dealerPanels = new CardPanel[10];
	CardPanel[] playerPanels = new CardPanel[10];
	
	MainFrame()
	{
		
		// places the card panels on the board
		
		for (int i = 0; i < 10; i++)
		{
			dealerPanels[i] = new CardPanel();
			dealerPanels[i].setBounds(Globals.D_ONE_LOCX + (i * Globals.CARD_HORIZONTAL_SPACING),
					                  Globals.D_ONE_LOCY, Globals.CARD_WI, Globals.CARD_HI);
			add(dealerPanels[i]);
			playerPanels[i] = new CardPanel();
			
			if (i < 5)
			{
				playerPanels[i].setBounds(Globals.P_ONE_LOCX + (i * Globals.CARD_HORIZONTAL_SPACING), 
		                  Globals.P_ONE_LOCY, Globals.CARD_WI, Globals.CARD_HI);
				add(playerPanels[i]);
			}
			else
			{
				playerPanels[i].setBounds(Globals.P_SIX_LOCX + (i * Globals.CARD_HORIZONTAL_SPACING), 
		                  Globals.P_ONE_LOCY, Globals.CARD_WI, Globals.CARD_HI);
				add(playerPanels[i]);
			}
		}
		
		// creates the deck
		deck.add(new Card('S', 'A', 11));
		deck.add(new Card('S', '1', 1));
		deck.add(new Card('S', '2', 2));
		deck.add(new Card('S', '3', 3));
		deck.add(new Card('S', '4', 4));
		deck.add(new Card('S', '5', 5));
		deck.add(new Card('S', '6', 6));
		deck.add(new Card('S', '7', 7));
		deck.add(new Card('S', '8', 8));
		deck.add(new Card('S', '9', 9));
		deck.add(new Card('S', 'T', 10));
		deck.add(new Card('S', 'J', 10));
		deck.add(new Card('S', 'Q', 10));
		deck.add(new Card('S', 'K', 10));
		
		deck.add(new Card('D', 'A', 11));
		deck.add(new Card('D', '1', 1));
		deck.add(new Card('D', '2', 2));
		deck.add(new Card('D', '3', 3));
		deck.add(new Card('D', '4', 4));
		deck.add(new Card('D', '5', 5));
		deck.add(new Card('D', '6', 6));
		deck.add(new Card('D', '7', 7));
		deck.add(new Card('D', '8', 8));
		deck.add(new Card('D', '9', 9));
		deck.add(new Card('D', 'T', 10));
		deck.add(new Card('D', 'J', 10));
		deck.add(new Card('D', 'Q', 10));
		deck.add(new Card('D', 'K', 10));
		
		deck.add(new Card('C', 'A', 11));
		deck.add(new Card('C', '1', 1));
		deck.add(new Card('C', '2', 2));
		deck.add(new Card('C', '3', 3));
		deck.add(new Card('C', '4', 4));
		deck.add(new Card('C', '5', 5));
		deck.add(new Card('C', '6', 6));
		deck.add(new Card('C', '7', 7));
		deck.add(new Card('C', '8', 8));
		deck.add(new Card('C', '9', 9));
		deck.add(new Card('C', 'T', 10));
		deck.add(new Card('C', 'J', 10));
		deck.add(new Card('C', 'Q', 10));
		deck.add(new Card('C', 'K', 10));

		deck.add(new Card('H', 'A', 11));
		deck.add(new Card('H', '1', 1));
		deck.add(new Card('H', '2', 2));
		deck.add(new Card('H', '3', 3));
		deck.add(new Card('H', '4', 4));
		deck.add(new Card('H', '5', 5));
		deck.add(new Card('H', '6', 6));
		deck.add(new Card('H', '7', 7));
		deck.add(new Card('H', '8', 8));
		deck.add(new Card('H', '9', 9));
		deck.add(new Card('H', 'T', 10));
		deck.add(new Card('H', 'J', 10));
		deck.add(new Card('H', 'Q', 10));
		deck.add(new Card('H', 'K', 10));
	}
}

