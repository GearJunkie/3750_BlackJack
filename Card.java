public class Card 
{
	public char suit;
	public char value;
	public int numValue;
	public String name;
	
	
	Card(char suit, char value, int numValue, String name)
	{
		this.suit = suit;
		this.value = value;
		this.numValue = numValue;
		this.name = name;
		
	}
	
	public void equals(Card otherCard)
	{
		//  Sets the values of the other card equal to the values of the current card
		this.suit = otherCard.suit;
		this.value = otherCard.value;
		this.numValue = otherCard.numValue;
	}
}
