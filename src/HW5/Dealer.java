package HW5;

import java.util.Iterator;

import HW5.Card;
import HW5.Dealer;
import HW5.Hand;
import HW5.IterableDeck;

public class Dealer {

  private final IterableDeck theDeck;
  private final int handSize;
  private final Iterator<Card> deckIterator;

  public Dealer(int handSize) {
    this.handSize = handSize;
    theDeck = new IterableDeck();
    theDeck.shuffle();
    deckIterator = theDeck.iterator();
  } // constructor

  public Hand getHand() {
    // NB: this will throw if an attempt is made to deal too many cards

    Card[] cards = new Card[handSize];

    for (int count = 0; count < handSize; count++) {
      if (!deckIterator.hasNext()) {
        String detail = "attempt to deal too many cards";
        throw new IllegalStateException(detail);
      } // if things are messed up

      cards[count] = deckIterator.next();
    } // for

    return new Hand(cards);

  } // getHand() 

  public static void main(String[] args) {

    Dealer dealer = new Dealer(5);
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

  } // main()

} // class Dealer 