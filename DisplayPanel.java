import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel 
{
	
	
	MainFrame frame;
	
	public String moneyPrompt = "Money Total: ";
	public String money;
	Font myFont = new Font ("Courier New" ,1 , 20);
	
	DisplayPanel(MainFrame frame)
	{
		money += "$500";
		this.frame = frame;
		setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g)
	{
		updateCountLables();
		g.setFont(myFont);
		g.setColor(Color.WHITE);
		//updateCountLables();	
		g.drawString(moneyPrompt + money, 10, 20);
		g.drawString(frame.strLHTotal, 10, 40);
	}
	
	private void updateCountLables() {
		// update all the count labels with all the running totals
		 frame.RHTotal = calculateHandValues(frame.rightHandValues);
		 frame.LHTotal = calculateHandValues(frame.leftHandValues);
		 
		 frame.strLHTotal = "";
		 
		 
		 frame.strLHTotal += "Left Total: " + frame.LHTotal + " ";
		 frame.strLHTotal += "Right Total: " + frame.RHTotal + " ";
		//add RHTotal and LHTotal to string in label display
		 
	}


	private int calculateHandValues(ArrayList<Integer> hand) 
	{
		// add numValue to hand and check for ACE
		int handTotal = 0;
		//add all numValues in hand
		
		for(Integer item : hand){
			handTotal += item;
		}
		//if BUST..
		if(handTotal > 21){
			//check for ace
				for(Integer item : hand){
					if (item == 11){
						//if ace.. handTotal -= 10
						handTotal -= 10;
				}
			}
			
		}
		return handTotal;
		
	}
}
