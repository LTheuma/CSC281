class ArrayRandomize {

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

    public static void printDeck(String[] cards) {
	for(String name : cards)
	    System.out.println(name);
	
    }

    public static void shuffle(String[] cards) {
	// Fisher-Yates algorithm
	for(int i = 0; i < cards.length; i++) {
	    int swapIndex = i + (int)( (cards.length-i)*Math.random());
	    String temp = cards[i];
	    cards[i] = cards[swapIndex];
	    cards[swapIndex] = temp;
	}
    }
    
    public static void main(String[] args) {

	String[] cards = initArray();

	shuffle(cards);
	
	printDeck(cards);

    }

}
