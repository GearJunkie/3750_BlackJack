import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CardPanel extends JPanel
{
	//private Card panelCard = new Card('0', '0', 0, "0");
	private Card panelCard = new Card('0', '0', 0, "0");
	URL url;
	ImageIcon image;
	loadImages cardImages;
	private Image concealedCard;
	public boolean concealed = false;
	static int repaintCounter = 0;
	
	CardPanel(loadImages cardIMages)
	{	
		setBackground(Color.GREEN);
		this.cardImages = cardIMages;
		try
		{
			concealedCard = ImageIO.read(getClass().getResource("/Concealed.png"));
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
	
	public void paintComponent(Graphics g)
	{
		//setVisible(true);
		if(concealed)
		{
			g.drawImage(concealedCard, 0, 0, Globals.CARD_WI, Globals.CARD_HI, null);
		}
		else
		{
			if(panelCard == null)
			{
				//System.out.println("Panel is null");
				setVisible(false);
			}
			else
			{				
				//System.out.println("Draw image called");
				g.drawImage(cardImages.getCardImage(panelCard), 0, 0, Globals.CARD_WI, Globals.CARD_HI, null);
			}
		}
		
		
		//g.drawRect(buffer, buffer, Globals.CARD_WI - buffer, Globals.CARD_HI - buffer);
	}
	
	public void setCard(Card panelCard)
	{
		this.panelCard = panelCard;
		setVisible(true);
	}
	
	public Card getCard()
	{
		return panelCard;
	}
	
}
