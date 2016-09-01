import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class CardPanel extends JPanel
{
	private static final int buffer = 5;
	
	CardPanel()
	{	
		setBackground(Color.GREEN);
	}
	
	public void paintComponent(Graphics g)
	{
		
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(buffer / 2));
		
		g.drawRect(buffer, buffer, Globals.CARD_WI - buffer, Globals.CARD_HI - buffer);
	}
}
