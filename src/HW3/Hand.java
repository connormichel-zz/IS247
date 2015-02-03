package HW3;

/*The Hand Class holds an array of Cards that is dealt from the Dealer class
Connor Michel 
Matt Benach
*/

public class Hand {
	
	private Card[] hand;
	
	public Hand(Card[] dealerHand){	
		
		this.hand = new Card[dealerHand.length];
		for(int i = 0; i < dealerHand.length; i++)
			this.hand[i] = dealerHand[i];
	}
	
	public String toString(){
		
		String returnState = hand[0].toString();
		for(int i = 1; i < hand.length; i++)
			returnState += ", " + hand[i].toString();
		return returnState;
	}
	
	public int size(){
		
		return hand.length;
	}
}
