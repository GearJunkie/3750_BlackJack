

import java.util.concurrent.TimeUnit;

import javax.swing.WindowConstants;

public class BlackJack 
{

	public static void main(String[] args)
	{
		MainFrame frame = new MainFrame();
		frame.setLayout(null);	
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(Globals.FRAME_WI, Globals.FRAME_HI);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
//		while(true)
//		{
//			System.out.println("Waiting...");
//			try {
//				TimeUnit.SECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			//frame.revalidate();
//		}
		
		
	}

}
