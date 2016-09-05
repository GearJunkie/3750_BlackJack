import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ActionButton extends JPanel 
{
	
	private final int DESCRIPT_BUFF = 5;
	String description;
	
	ActionButton(String description)
	{
		this.description = description;
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Globals.BUTTON_WI, Globals.BUTTON_HI);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
		
		g.drawString(description, DESCRIPT_BUFF, Globals.BUTTON_HI - DESCRIPT_BUFF * 3);
		
	}

}
