package HW4;

public class Card implements Comparable<Card>{

	  private final int  rank;
	  private final Suit theSuit;

	  protected final int LO_RANK = 2;
	  protected final int HI_RANK = 14;

	  public Card(int rank, Suit suit) {
	    if (rank < LO_RANK) {
	      final String detail = "Rank " + rank + " is too low.";
	      throw new IllegalArgumentException(detail);
	    }
	    else if (rank > HI_RANK) {
	      final String detail = "Rank " + rank + " is too high.";
	      throw new IllegalArgumentException(detail);
	    } // else if

	    this.rank = rank;
	    theSuit   = suit;
	  } // constructor

	  public int getRank() {
	    return rank;
	  } // getRank()

	  public Suit getSuit() {
	    return theSuit;
	  } // getSuit()

	  public String toString() {
	    return 
	      abbreviation(rank)
	      + " of "
	      + theSuit.name().toLowerCase().charAt(0);
	  } // toString()

	  private String abbreviation(int rank) {
	    if (rank < LO_RANK || rank > HI_RANK)
	      return "??";

	    switch (rank) {
	    case 11:
	      return "j";
	    case 12:
	      return "q";
	    case 13:
	      return "k";
	    case 14:
	      return "a";
	    default:
	      return Integer.toString(rank);
	    } // switch

	  } // abbreviation()

	  public static void main(String[] args) {

	    Card a = new Card(3, Suit.SPADES);
	    Card b = new Card(10, Suit.DIAMONDS);
	    Card c = new Card(14, Suit.CLUBS);
	    System.out.println(a + ", " + b + ", " + c);

	    System.out.println("\u2660" + ", "
	                       + "\u2661" + ", "
	                       + "\u2661" + ", "
	                       + "\u2662" + ", "
	                       + "\u2663");
	  } // main()

	@Override
	public int compareTo(Card other) {
		// TODO Auto-generated method stub
		int otherRank = other.getRank();
		Suit otherSuit = other.getSuit();
		
		if(rank-otherRank!=0)
			return rank-otherRank;
		else if(theSuit.ordinal()-otherSuit.ordinal()!=0)
			return theSuit.ordinal()-otherSuit.ordinal();
		return 0;
	}

} // class Card