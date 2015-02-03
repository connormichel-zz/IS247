package HW3;

public class Deck {

	  protected final Card[] theDeck;
	  protected final int cardsInDeck = 52;

	  public Deck() {
	    theDeck = new Card[cardsInDeck];

	    int currentCard = 0;
	    for (int rank = 2; rank < 15; ++rank) {
	      for (Suit theSuit: Suit.values()) {
	        theDeck[currentCard++] = new Card(rank, theSuit);
	      } // for each suit
	    } // for each rank
	  } // no-arg constructor

	  public String toString() {
	    String s = new String();
	    for (Card c: theDeck) 
	      s = s + c + '\n';
	    return s;
	  } // toString() 


	  public static void main(String[] args) {
	    Deck d = new Deck();
	    System.out.println(d);
	  } // main()

	} // class Deck
