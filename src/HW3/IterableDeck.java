package HW3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Random;

public class IterableDeck extends Deck implements Iterable<Card> {

  private final Random prng;

  public IterableDeck() {
    super();
    prng = new Random();
  } // no-arg constructor

  public Iterator<Card> iterator() {
    return new DeckIterator();
  } // iterator() 

  public void shuffle() {
    for (int index = 0; index < theDeck.length; index++)
      swap(index, prng.nextInt(cardsInDeck));
  } // shuffle()

  // swap two two cards of theDeck
  private void swap(int a, int b) {
    Card temp = theDeck[a];
    theDeck[a] = theDeck[b];
    theDeck[b] = temp;
  } // swap()

  protected class DeckIterator implements Iterator<Card> {
    private int current = 0;
    
    public boolean hasNext() {
      return current < theDeck.length;
    } // hasNext()

    public Card next() {
      return theDeck[current++];
    } // next()

    public void remove() {
      throw new UnsupportedOperationException("remove not implemented");
    } // return()

  } // class DeckIterator

  public static PrintStream openOutputFile(String name) 
    throws FileNotFoundException
  {
    FileOutputStream outStream = new FileOutputStream(name);
    return new PrintStream(outStream);
  } // openOutputFile()

  public static void main(String[] args) {

    IterableDeck deck = null;
    try {
      deck = new IterableDeck();
    } // try
    catch (IllegalArgumentException e) {
      System.err.println(e);
    } // catch
    
    PrintStream out;
    try {
      out = openOutputFile("unshuffled.txt");
      for (Card aCard: deck)
        out.println(aCard);
      out.close();
    } // try
    catch (FileNotFoundException e) {
      System.err.println(e);
    } // catch

    try {
      out = openOutputFile("shuffled.txt");
      deck.shuffle();
      Iterator<Card> it = deck.iterator();
      while (it.hasNext())
        out.println(it.next());
      out.close();
    } // try
    catch (FileNotFoundException e) {
      System.err.println(e);
    } // catch

  } // main()

} // class IterableDeck 