public class Fibonacci {

    public static final int numMemoize = 3;
    public static int[] lastCalls;
    private static long[] lastValues;

    public static long fib(int n) {
	if(n == 0 || n == 1)
	    return 1;

	if( n == lastCalls[n % numMemoize] )
	    return lastValues[n % numMemoize];

	long retVal = fib(n-2)+fib(n-1);
	lastCalls[n % numMemoize] = n;
	lastValues[n % numMemoize] = retVal;
	//System.out.println("n="+n+" v="+retVal);
	
	
	return retVal;
	
    }

    public static long fibNaive(int n) {

	if( n == 1 || n == 0)
	    return 1;
	else
	    return fibNaive(n-1)+fibNaive(n-2);
	
    }

    
    public static void main(String[] args) {

	lastCalls = new int[numMemoize];
	lastValues = new long[numMemoize];

	int n = Integer.valueOf(args[0]);

	System.out.println(fib(n));
	//System.out.println(fibNaive(n));

    }
    

}
