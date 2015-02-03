package HW3;

import java.util.Iterator;

/*The Dealer class takes a number of cards, shuffles them, and then deals the cards to the players
 * Connor Michel
 * Matt Benach
 */

public class Dealer {

	private final int size;
	private Iterator<Card> it;
	
	public Dealer(int size){
		
		this.size=size;
		IterableDeck theDeck = new IterableDeck();
		theDeck.shuffle();
		this.it=theDeck.iterator();
	}
	
	public Hand getHand(){
		
		Card[] hand = new Card[size];
		int count = 0;
		while(it.hasNext() && count < size){
			hand[count] = it.next();
			count++;
		}
		Hand player = new Hand(hand);
		return player;
	}

	public static void main(String[] args) {
	
		Dealer tom = new Dealer(5);
		System.out.println("Player a");
		System.out.println(tom.getHand());
		System.out.println("Player b");
		System.out.println(tom.getHand());
		System.out.println("Player c");
		System.out.println(tom.getHand());

	}
}






