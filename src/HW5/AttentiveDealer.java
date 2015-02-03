package HW5;

/*
 * Connor Michel
 * Matt Benach
 * IS 247 Program 5
 */

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;


public class AttentiveDealer extends Dealer{
	
	private Set<Card> seti;

	public AttentiveDealer(int handSize) {
		super(handSize);
		seti = new TreeSet<Card>();
	}

	public boolean alreadyDealt(Card aCard){
		return seti.contains(aCard);
	}
	
	public Hand getHand(){
		Hand hand = super.getHand();
		Iterator<Card> it = hand.iterator();
		while(it.hasNext())
			seti.add(it.next());
		return hand;
	}
	
	public boolean inHand(int rank, String suitString){
		Suit suit = null;
		
		if(suitString.compareTo("c") == 0 || suitString.compareTo("C") == 0)
			suit = Suit.CLUBS;
		else if(suitString.compareTo("d") == 0 || suitString.compareTo("D") == 0)
			suit = Suit.DIAMONDS;
		else if(suitString.compareTo("h") == 0 || suitString.compareTo("H") == 0)
			suit = Suit.HEARTS;
		else
			suit = Suit.SPADES;
		
		Card cardFind = new Card(rank, suit);
		return alreadyDealt(cardFind);
	}

public static void main(String[] args) {

    AttentiveDealer dealer = new AttentiveDealer(5);
    Hand a = dealer.getHand();
    Hand b = dealer.getHand();
    Hand c = dealer.getHand();

    System.out.println("Player a"
                       + "\n  "
                       + a.toString());

    System.out.println("Player b"
                       + "\n  "
                       + b.toString());

    System.out.println("Player c"
                       + "\n  "
                       + c.toString());
    System.out.println();
    
    int rank = 0;
    String suit = "";
    String prompt1 = "Enter a rank, negative to quit: ";
    String prompt2 = "Enter a suit: ";
    Scanner inputRank = new Scanner(System.in);
    Scanner inputSuit = new Scanner(System.in);
    
    while(rank>=0){
    	System.out.print(prompt1);
    	rank = inputRank.nextInt();
    	
    	if(rank>=0){
    		System.out.print(prompt2);
    		suit = inputSuit.next();
    		
    		if((dealer.inHand(rank, suit)))
    			System.out.println("The " + rank + " of " + suit + " has been dealt.");
    		else
    			System.out.println("The " + rank + " of " + suit + " has not been dealt.");	
    	} 
    }
}
}