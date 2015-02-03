package HW4;

import java.util.Arrays;

//Time-stamp: <2013-04-08 15:40:31 jdm>

public class Hand {

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

} // class Hand 