/**
 * <code>ArrayRandomize</code> prints a shuffled deck of cards
 *
 * @author <a href="mailto:knapp@american.edu">Adam Knapp</a>
 * @version 1.0
 */
class ArrayRandomize {

    /**
     * @param i the card's zero-based value i.e. Ace=0 2=1 etc.
     * @return a <code>String</code> giving the card's name
     */
    public static String cardName(int i) {
	if(i == 0)
	    return "Ace";
	else if(i < 10)
	    return String.valueOf(i+1);
	else if(i == 10)
	    return "Jack";
	else if(i == 11)
	    return "Queen";
	else
	    return "King";
    }
    
    /**
     * Initializes the deck in order
     *
     * @return the deck
     */
    public static String[] initArray() {
	String[] cards = new String[52];

	for(int i = 0; i < 13; i++) {
	    cards[i] = cardName(i) + " of Hearts";
	}

	for(int i = 0; i < 13; i++) {
	    cards[i+13] = cardName(i) + " of Diamonds";
	}

	for(int i = 0; i < 13; i++) {
	    cards[i+2*13] = cardName(i) + " of Spades";
	}

	for(int i = 0; i < 13; i++) {
	    cards[i+3*13] = cardName(i) + " of Clubs";
	}

	return cards;
    }

    /**
     * prints the deck
     *
     * @param cards the deck
     */
    public static void printDeck(String[] cards) {
	for(String name : cards)
	    System.out.println(name);
	
    }

    /**
     * shuffles the deck (in place)
     *
     * @param cards the deck
     */
    public static void shuffle(String[] cards) {
	// Fisher-Yates algorithm
	for(int i = 0; i < cards.length; i++) {
	    int swapIndex = i + (int)( (cards.length-i)*Math.random());
	    String temp = cards[i];
	    cards[i] = cards[swapIndex];
	    cards[swapIndex] = temp;
	}
    }
    
    /**
     * entry point of execution
     *
     * @param args ignored
     */
    public static void main(String[] args) {

	String[] cards = initArray();

	shuffle(cards);
	
	printDeck(cards);

    }

}
