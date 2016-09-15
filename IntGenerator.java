class IntGenerator {

    public static void main(String[] args) {

	int numInts = Integer.parseInt(args[0]);
	
	System.out.println(numInts);
	
	for(int i = 0; i < numInts; i++)
	    System.out.println((int)(Integer.MAX_VALUE*Math.random()));
	

    }


}
