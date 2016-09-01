
public class Card 
{
	public char suit;
	public char value;
	public int numValue;
	
	Card(char suit, char value, int numValue)
	{
		this.suit = suit;
		this.value = value;
		this.numValue = numValue;
		
	}
	
	public void equals(Card otherCard)
	{
		this.suit = otherCard.suit;
		this.value = otherCard.value;
		this.numValue = otherCard.numValue;
	}
}
