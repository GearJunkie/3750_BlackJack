import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class loadImages 
{
	ImageIcon image;
	Image[] cardImages = new Image[52];
	String[] cardURLs = new String[52];
	
	loadImages()
	{
		cardURLs[0] = "AceSpades";
		cardURLs[1] = "TwoSpades";
		cardURLs[2] = "ThreeSpades";
		cardURLs[3] = "FourSpades";
		cardURLs[4] = "FiveSpades";
		cardURLs[5] = "SixSpades";
		cardURLs[6] = "SevenSpades";
		cardURLs[7] = "EightSpades";
		cardURLs[8] = "NineSpades";
		cardURLs[9] = "TenSpades";
		cardURLs[10] = "JackSpades";
		cardURLs[11] = "QueenSpades";
		cardURLs[12] = "KingSpades";
		
		cardURLs[13] = "AceDiamonds";
		cardURLs[14] = "TwoDiamonds";
		cardURLs[15] = "ThreeDiamonds";
		cardURLs[16] = "FourDiamonds";
		cardURLs[17] = "FiveDiamonds";
		cardURLs[18] = "SixDiamonds";
		cardURLs[19] = "SevenDiamonds";
		cardURLs[20] = "EightDiamonds";
		cardURLs[21] = "NineDiamonds";
		cardURLs[22] = "TenDiamonds";
		cardURLs[23] = "JackDiamonds";
		cardURLs[24] = "QueenDiamonds";
		cardURLs[25] = "KingDiamonds";
		
		cardURLs[26] = "AceClubs";
		cardURLs[27] = "TwoClubs";
		cardURLs[28] = "ThreeClubs";
		cardURLs[29] = "FourClubs";
		cardURLs[30] = "FiveClubs";
		cardURLs[31] = "SixClubs";
		cardURLs[32] = "SevenClubs";
		cardURLs[33] = "EightClubs";
		cardURLs[34] = "NineClubs";
		cardURLs[35] = "TenClubs";
		cardURLs[36] = "JackClubs";
		cardURLs[37] = "QueenClubs";
		cardURLs[38] = "KingClubs";
		
		cardURLs[39] = "AceHearts";
		cardURLs[40] = "TwoHearts";
		cardURLs[41] = "ThreeHearts";
		cardURLs[42] = "FourHearts";
		cardURLs[43] = "FiveHearts";
		cardURLs[44] = "SixHearts";
		cardURLs[45] = "SevenHearts";
		cardURLs[46] = "EightHearts";
		cardURLs[47] = "NineHearts";
		cardURLs[48] = "TenHearts";
		cardURLs[49] = "JackHearts";
		cardURLs[50] = "QueenHearts";
		cardURLs[51] = "KingHearts";
		
		
		//  Pulls the .png files from the hard drive and sets them to a image object
		for (int i = 0; i < 52; i++)
		{
			//System.out.println(cardURLs[i]);
			
			try
			{
				cardImages[i] = ImageIO.read(getClass().getResource("/" + cardURLs[i] + ".png"));
			}
			catch(IOException e)
			{
				System.err.println(e);
			}
		}
	}
	
	public Image getCardImage(Card card)
	{
		for (int i = 0; i < 52; i++)
		{
			if (card.name.contentEquals(cardURLs[i]))
			{
				return (Image) cardImages[i];
			}
		}
		// This should not happen
		return null;
	}
	
	
}