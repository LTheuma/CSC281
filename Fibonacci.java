class Fibbonacci {

    public static final int numMemoize = 3;
    public static int[] lastCalls;
    public static int[] lastValues;

    public static int fib(int n) {
	if(n == 0 || n == 1)
	    return 1;

	if( n == lastCalls[n % numMemoize] )
	    return lastValues[n % numMemoize];

	int retVal = fib(n-2)+fib(n-1);
	lastCalls[n % numMemoize] = n;
	lastValues[n % numMemoize] = retVal;
	System.out.println("n="+n+" v="+retVal);
	
	
	return retVal;
	
    }
    
    public static void main(String[] args) {

	lastCalls = new int[numMemoize];
	lastValues = new int[numMemoize];

	int n = Integer.valueOf(args[0]);

	System.out.println(fib(n));
	

    }
    

}
