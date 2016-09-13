/**
 * Prints factorial given command line arguments
 *
 * @author <a href="mailto:knapp@american.edu">Adam Knapp</a>
 * @version 1.0
 */
class Factorial {

    /**
     * The classic factorial function defined by 0!=1 and n! = n*(n-1)!
     *
     * @param n a non-negative integer value
     * @return value of n!
     */
    public static long factorial(long n) {

	if( n == 0 )
	    return 1;
	else
	    return n * factorial(n-1);
	
    }
    

    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {

	try {
	    try {
		long n = (long) Integer.parseInt(args[0]);
		System.out.println(factorial(n));
	    } catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("what's the number?");
	    }
	} catch (NumberFormatException e) {
	    System.out.println("could not parse argument as Integer");
	    
	}

    }

}
