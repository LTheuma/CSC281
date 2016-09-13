/**
 * <code>MontyHall</code> simulates the classic Monty Hall problem
 *
 * @author <a href="mailto:knapp@american.edu">Adam Knapp</a>
 * @version 1.0
 */
class MontyHall {

    
    /**
     * GOAT id
     */
    static int GOAT = 0;

    /**
     * CAR id
     */
    static int CAR = 1;

    
    /**
     * <code>generateDoors</code> does the initial setup of the array
     * of doors
     *
     * @return <code>int[]</code> giving the 3 doors
     */
    public static int[] generateDoors() {
	int[] doors = new int[3];
	int carIndex = (int) ( 3* Math.random() );
	doors[carIndex] = CAR;
	return doors;
    }

    /**
     * <code>getDoorShown</code> returns the door Monty will show you
     *
     * @param guess the player's guess
     * @param doors the current array of doors
     * @return the index of a door which hides a goat and is not the
     * guess
     */
    public static int getDoorShown(int guess, int[] doors) {
	int shownGoat;
	do {
	    shownGoat = (int) (3* Math.random());
	} while( shownGoat == guess || doors[shownGoat] == CAR);
	return shownGoat;
    }

    
    /**
     * Runs the simulation
     *
     * @param args the first command line argument give the number of
     * iterations to run the simulation
     */
    public static void main(String[] args) {

	int iterations = Integer.valueOf(args[0]);
	int winCount = 0;
	
	for(int iter = 0; iter < iterations; iter++) {

	    int[] doors = generateDoors();

	    int guess = (int) ( 3*Math.random() );

	    int doorShown = getDoorShown(guess,doors);

	    // switch doors
	    int newGuess = -1;
	    for(int i = 0; i<3; i++)
		if(i != guess && i != doorShown)
		    newGuess = i;

	    // check to see if we won
	    if(doors[newGuess] == CAR)
		winCount++;
	    
	}

	System.out.println("Win pct:" + ((100.0*winCount)/iterations) );
	
    }
}
