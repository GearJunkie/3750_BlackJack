import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

//import MainFrame.playerSide;


public class MainFrame extends JFrame 
{
	ArrayList<Card> deck = new ArrayList<Card>();
	
	CardPanel[] dealerPanels = new CardPanel[10];
	CardPanel[] playerPanels = new CardPanel[10];
	loadImages cardImages = new loadImages();
	
//	ActionButton leftHit = new ActionButton("HIT");
//	ActionButton leftStand = new ActionButton("STAND");
//	
//	ActionButton rightHit = new ActionButton("HIT");
//	ActionButton rightStand = new ActionButton("STAND");
	
	JButton leftHit = new JButton("Hit");
	JButton leftStand = new JButton("Stand");
	JButton rightHit = new JButton("Hit");
	JButton rightStand = new JButton("Stand");
	JButton splitButton = new JButton("Split");
	
	private enum playerSide{leftHand, rightHand, dealer}
	private int deckPos = 0;
	private int leftHandCard = 0;
	private int rightHandCard = 5;
	private int dealerCard = 0;
	private int money = 500;
	
	private boolean split = false;
	
	MainFrame()
	{
		
		
		// places the card panels on the board
		for (int i = 9; i >= 0; i--)
		{
			dealerPanels[i] = new CardPanel(cardImages);
			dealerPanels[i].setBounds(Globals.D_ONE_LOCX + (i * Globals.CARD_HORIZONTAL_SPACING),
					                  Globals.D_ONE_LOCY, Globals.CARD_WI, Globals.CARD_HI);
			add(dealerPanels[i]);
			playerPanels[i] = new CardPanel(cardImages);
			
			//  sets the locations of the panels that the cards will be placed in.
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
		
		addButton(leftHit, Globals.LEFT_HIT_LOCX, Globals.LEFT_HIT_LOCY, Globals.BUTTON_WI, Globals.BUTTON_HI);
		addButton(leftStand, Globals.LEFT_STAND_LOCX, Globals.LEFT_STAND_LOCY, Globals.BUTTON_WI, Globals.BUTTON_HI);
		addButton(rightHit, Globals.RIGHT_HIT_LOCX, Globals.RIGHT_HIT_LOCY, Globals.BUTTON_WI, Globals.BUTTON_HI);
		addButton(rightStand, Globals.RIGHT_STAND_LOCX, Globals.RIGHT_STAND_LOCY, Globals.BUTTON_WI, Globals.BUTTON_HI);
		addButton(splitButton, Globals.SPLIT_LOCX, Globals.SPLIT_LOCY, Globals.BUTTON_WI, Globals.BUTTON_HI);
		
		createDeck();
		//Collections.shuffle(deck);
		newDeal();
		
		URL url = getClass().getResource("/TableFelt.png");
		JLabel background=new JLabel(new ImageIcon(url));
	    background.setBounds(0, 0, Globals.FRAME_WI, Globals.FRAME_HI);
		add(background);
		
	}
	
	
	//  Call this function to deal a new hand.
	private void newDeal()
	{
		
		//  Sets all the panels to null, so they will not show any cards
		for (int i = 0; i < 10; i++)
		{
			dealerPanels[i].setCard(null);
			playerPanels[i].setCard(null);
			dealerPanels[i].repaint();
			playerPanels[i].repaint();
		}
		
		// Shuffles the deck
		Collections.shuffle(deck);
		//  re-initializes all the variables needed for a new deal
		deckPos = 0;
		leftHandCard = 0;
		rightHandCard = 5;
		dealerCard = 0;
		split = false;
		leftStand.setVisible(true);
		leftHit.setVisible(true);
		rightHit.setVisible(false);
		rightStand.setVisible(false);
		splitButton.setVisible(false);
		
		
		//  Sets the dealers second card to concealed status, so the player cannot see it (as per standard blackjack rules)
		dealerPanels[1].concealed = true;
		
		//  Deals out the starting cards for the dealer and the player
		dealCard(playerSide.leftHand);
		dealCard(playerSide.dealer);
		dealCard(playerSide.leftHand);
		dealCard(playerSide.dealer);
	}
	
	private void addButton(JButton button, int locX, int locY, int Wi, int Hi)
	{
		button.setBounds(locX, locY, Wi, Hi);
//		button.setBackground(Color.CYAN);
//		button.setForeground(Color.BLUE);
		button.setBorderPainted(true);
		
		//button.addActionListener(l);
		
		button.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) 
		    {
		    	buttonPressed(button, e);
		    }
		});
		
		add(button);
	}
	
	/*
	 * Call this function to deal a card to the player's left side, right side, or to the dealer
	 * The player's right side should only be active if they have a split
	 */
	private void dealCard(playerSide side)
	{

		if(side == playerSide.leftHand)
		{
			playerPanels[leftHandCard].setCard(deck.get(deckPos));
			//System.out.println(playerPanels[leftHandCard].getCard().numValue);
			leftHandCard++;
		}
		else if (side == playerSide.rightHand)
		{
			playerPanels[rightHandCard].setCard(deck.get(deckPos));
			rightHandCard++;
		}
		else if (side == playerSide.dealer)
		{
			dealerPanels[dealerCard].setCard(deck.get(deckPos));
			dealerCard++;
		}
		deckPos++;
		
	}
	
	//  This function should only be called once.  Once the deck is created, it won't need to be created again.
	private void createDeck()
	{
		// creates the deck
		deck.add(new Card('S', 'A', 11, "AceSpades"));
		deck.add(new Card('S', '2', 2, "TwoSpades"));
		deck.add(new Card('S', '3', 3, "ThreeSpades"));
		deck.add(new Card('S', '4', 4, "FourSpades"));
		deck.add(new Card('S', '5', 5, "FiveSpades"));
		deck.add(new Card('S', '6', 6, "SixSpades"));
		deck.add(new Card('S', '7', 7, "SevenSpades"));
		deck.add(new Card('S', '8', 8, "EightSpades"));
		deck.add(new Card('S', '9', 9, "NineSpades"));
		deck.add(new Card('S', 'T', 10, "TenSpades"));
		deck.add(new Card('S', 'J', 10, "JackSpades"));
		deck.add(new Card('S', 'Q', 10, "QueenSpades"));
		deck.add(new Card('S', 'K', 10, "KingSpades"));
		
		deck.add(new Card('D', 'A', 11, "AceDiamonds"));
		deck.add(new Card('D', '2', 2, "TwoDiamonds"));
		deck.add(new Card('D', '3', 3, "ThreeDiamonds"));
		deck.add(new Card('D', '4', 4, "FourDiamonds"));
		deck.add(new Card('D', '5', 5, "FiveDiamonds"));
		deck.add(new Card('D', '6', 6, "SixDiamonds"));
		deck.add(new Card('D', '7', 7, "SevenDiamonds"));
		deck.add(new Card('D', '8', 8, "EightDiamonds"));
		deck.add(new Card('D', '9', 9, "NineDiamonds"));
		deck.add(new Card('D', 'T', 10, "TenDiamonds"));
		deck.add(new Card('D', 'J', 10, "JackDiamonds"));
		deck.add(new Card('D', 'Q', 10, "QueenDiamonds"));
		deck.add(new Card('D', 'K', 10, "KingDiamonds"));
		
		deck.add(new Card('C', 'A', 11, "AceClubs"));
		deck.add(new Card('C', '2', 2, "TwoClubs"));
		deck.add(new Card('C', '3', 3, "ThreeClubs"));
		deck.add(new Card('C', '4', 4, "FourClubs"));
		deck.add(new Card('C', '5', 5, "FiveClubs"));
		deck.add(new Card('C', '6', 6, "SixClubs"));
		deck.add(new Card('C', '7', 7, "SevenClubs"));
		deck.add(new Card('C', '8', 8, "EightClubs"));
		deck.add(new Card('C', '9', 9, "NineClubs"));
		deck.add(new Card('C', 'T', 10, "TenClubs"));
		deck.add(new Card('C', 'J', 10, "JackClubs"));
		deck.add(new Card('C', 'Q', 10, "QueenClubs"));
		deck.add(new Card('C', 'K', 10, "KingClubs"));

		deck.add(new Card('H', 'A', 11, "AceHearts"));
		deck.add(new Card('H', '2', 2, "TwoHearts"));
		deck.add(new Card('H', '3', 3, "ThreeHearts"));
		deck.add(new Card('H', '4', 4, "FourHearts"));
		deck.add(new Card('H', '5', 5, "FiveHearts"));
		deck.add(new Card('H', '6', 6, "SixHearts"));
		deck.add(new Card('H', '7', 7, "SevenHearts"));
		deck.add(new Card('H', '8', 8, "EightHearts"));
		deck.add(new Card('H', '9', 9, "NineHearts"));
		deck.add(new Card('H', 'T', 10, "TenHearts"));
		deck.add(new Card('H', 'J', 10, "JackHearts"));
		deck.add(new Card('H', 'Q', 10, "QueenHearts"));
		deck.add(new Card('H', 'K', 10, "KingHearts"));
	}
	
	public void buttonPressed(JButton button, ActionEvent e)
	{

		//  Checks to see which button was pressed and responds accordingly
		if(e.getSource() == leftHit)
		{
			//System.out.println("Left Hit");
			dealCard(playerSide.leftHand);
		}
		else if (e.getSource() == rightHit)
		{
			dealCard(playerSide.rightHand);
		}
		else if (e.getSource() == leftStand)
		{
			//****** DEALER AI TESTING *****
			dealerTurn();
			
			/* if(split)
			{
				leftHit.setVisible(false);
				leftStand.setVisible(false);
				rightHit.setVisible(true);
				rightStand.setVisible(true);
			}
			else
			{
				dealerTurn();
			} */
			

		}
		else if (e.getSource() == rightStand)
		{
			dealerTurn();
		}
		
		//  This is for the 5 card rule.  If the player collects 5 cards, it is a automatic win.
		if (playerPanels[4].getCard() != null)
		{
			//System.out.println("Additional Code run");
			dealerTurn();  //  For debugging purposes
			if(split)
			{
				money += Globals.BET_SIZE;
				leftHit.setVisible(false);
				leftStand.setVisible(false);
				rightHit.setVisible(true);
				rightStand.setVisible(true);
			}
			else
			{
				money+= Globals.BET_SIZE;
				newDeal();
			}
		}
		
		if (playerPanels[9].getCard() != null)
		{
			//System.out.println("Additional Code run");
			dealerTurn();
			money += Globals.BET_SIZE;
			newDeal();
		}
		
	}
	
	private void dealerTurn()
	{
		//  ASSIGNMENT: Deals cards to the dealer until the dealer reaches the value of 17
		//  The dealer will hit on a "soft" 17.  A soft 17 means they have 17 with an ace that equals 11
		//  If they hit and bust with a soft 17 and get over 21, their Ace becomes a 1
		int dealerHandValue = 0;
		int playerLeftHandValue = 0;
		int playerRightHandValue = 0;
		boolean dealerAce = false;
		
		dealerPanels[1].concealed = false;
		dealerPanels[1].repaint();
		
		leftHit.setVisible(false);
		leftStand.setVisible(false);
		rightHit.setVisible(false);
		rightStand.setVisible(false);
		
		
		
		// Determine dealer hand value
		for (int i = 0; i < 2; i++)
		{
			dealerHandValue += dealerPanels[i].getCard().numValue;
			
			// Checks if the dealer has an Ace
			if (dealerPanels[i].getCard().numValue == 11)
				dealerAce = true;
		}
		
		// Determine left hand value
		for (int i = 0; i < leftHandCard; i++)
		{
			playerLeftHandValue += playerPanels[i].getCard().numValue;
		}
		
		// Dealer AI
		for (int i = 0; i < 8; i++)
		{
			// Deals dealer a new card and updates dealerHandValue if dealer hand value is less than 17
			// If dealer has an ace and a hand value of 17, deal new card and change ace to 1
			
			/*for (int j = 0; j < dealerCard; i++)
			{
				dealerPanels[j].repaint();
			}*/
			
			
			
			System.out.println(dealerHandValue);
			if (dealerHandValue > playerLeftHandValue && dealerHandValue > playerRightHandValue)
			{
				break;
			}
			
			if (dealerHandValue < 17 || (dealerHandValue < playerLeftHandValue && dealerHandValue < playerRightHandValue))
			{
				JOptionPane.showMessageDialog(this, "Next card");
				System.out.println("new card dealt");
				dealCard(playerSide.dealer);
				dealerHandValue += dealerPanels[dealerCard - 1].getCard().numValue;
			}
			else if (dealerHandValue == 17 && dealerAce == true)
			{
				JOptionPane.showMessageDialog(this, "Next card");
				System.out.println("new card dealt");
				dealerHandValue -= 10;		// Ace is changed from value 11 to 1
				dealCard(playerSide.dealer);
				dealerHandValue += dealerPanels[dealerCard - 1].getCard().numValue;
				dealerAce = false;			// Ace value is changed to 1, so dealerAce is set to false
			}
			else
			{
				break;
			}
			
			// Checks for any new dealt Ace
			if (dealerPanels[dealerCard - 1].getCard().numValue == 11)
				dealerAce = true;
			
			revalidate();
		}
		
		if(split)
		{
			//  Check dealer against left and right side - determine if player gets winnings or not
			
			// Determine right hand value
			for (int i = 0; i < rightHandCard; i++)
			{
				playerRightHandValue += playerPanels[i + (leftHandCard - 1)].getCard().numValue;
			}
			
			// Determine who wins
			if (dealerHandValue > 21)
			{
				dealerHandValue = 0;
				JOptionPane.showMessageDialog(this, "Dealer busts, player Wins!");
			}
			else if (dealerHandValue > playerLeftHandValue && dealerHandValue > playerRightHandValue)
			{
				System.out.println("Dealer Wins!");
			}
			else
			{
				if (dealerHandValue < playerLeftHandValue)
				{
					System.out.println("Player's Left Hand Wins!");
					money += Globals.BET_SIZE;
				}
				
				if (dealerHandValue < playerRightHandValue)
				{
					System.out.println("Player's Right Hand Wins!");
					money += Globals.BET_SIZE;
				}
			}
		}
		else
		{
			//  Check dealer against left side only
			
			// Determine who wins
			if (dealerHandValue > 21)
			{
				dealerHandValue = 0;
				JOptionPane.showMessageDialog(this, "Dealer busts, player Wins!");
			}
			else if (dealerHandValue > playerLeftHandValue)
			{
				JOptionPane.showMessageDialog(this, "Dealer Wins!");
			}
			else if (dealerHandValue < playerLeftHandValue)
			{
				JOptionPane.showMessageDialog(this, "Player Wins");
				money += Globals.BET_SIZE;
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Draw");
			}
		}
		
		newDeal();

	}
	
}