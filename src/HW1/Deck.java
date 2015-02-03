package HW1;

public class Deck {
	
	protected final Card[] theDeck;
	protected final int SIZE = 52;
	
	public Deck(){
		theDeck = new Card[SIZE];
	    int currentCard = 0;
	    for (int rank = 2; rank < 15; ++rank){
	      for (Suit theSuit: Suit.values()){
	        	theDeck[currentCard++] = new Card(rank, theSuit);
	      }
	    }
	}
	
	public String toString(){
		String print = "";
		for(int i=0; i<theDeck.length; i++){
	    	if(theDeck[i].getRank() == 11)
	    		print += "j of " + theDeck[i].getSuit() + "\n";
	    	else if(theDeck[i].getRank() == 12)
	    		print += "q of " + theDeck[i].getSuit() + "\n";
	    	else if(theDeck[i].getRank() == 13)
	    		print += "k of " + theDeck[i].getSuit() + "\n";
	    	else if(theDeck[i].getRank() == 14)
	    		print += "a of " + theDeck[i].getSuit() + "\n";
	    	else
	    		print += theDeck[i].toString() + "\n";
		}
		return print;
	}
}
