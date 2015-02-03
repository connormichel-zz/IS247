package HW5;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class Hand implements Iterable<Card>{

  private Card[] theCards;
  
  public Hand(Card[] theCards) {
    this.theCards = theCards;
    Arrays.sort(theCards);
  } // constructor

  public int size() {
    return theCards.length; 
  } // size()

  public String toString() {
    String s = theCards[0].toString();
    
    for (int index = 1; index < theCards.length; index++)
      s += ", " + theCards[index].toString();
    return s;
  } // toString()

  	@Override
	public Iterator<Card> iterator() {
  	    List<Card> aHand = new ArrayList<Card>(theCards.length);
  	    for (Card c: theCards)
  	      aHand.add(c);
  	    return aHand.iterator();
  	}

} // class Hand 